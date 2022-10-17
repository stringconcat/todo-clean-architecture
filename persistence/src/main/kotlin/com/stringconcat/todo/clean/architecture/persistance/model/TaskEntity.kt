package com.stringconcat.todo.clean.architecture.persistance.model

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.domain.TaskDescription
import com.stringconcat.todo.clean.architecture.domain.TaskId
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TaskEntity(
    @Id val id: UUID,
    val description: String,
    val deadline: LocalDateTime,
    val priority: Priority
) {

    enum class Priority {
        LOW, MIDDLE, HIGH;

        companion object {
            fun fromBusiness(p: Task.Priority): Priority =
                when (p) {
                    Task.Priority.LOW -> LOW
                    Task.Priority.MIDDLE -> MIDDLE
                    Task.Priority.HIGH -> HIGH
                    else -> {
                        throw IllegalStateException("Invalid rating param value")
                    }
                }


            fun toBusiness(p: Priority): Task.Priority =
                when (p) {
                    LOW -> Task.Priority.LOW
                    MIDDLE -> Task.Priority.MIDDLE
                    HIGH -> Task.Priority.HIGH
                }

        }
    }

    companion object {
        fun fromBusiness(t: Task): TaskEntity =
            TaskEntity(
                id = t.id.toUUIDValue()!!,
                description = t.description.toStringValue(),
                deadline = t.deadline.toLocalDateTimeValue(),
                priority = Priority.fromBusiness(t.priority)
            )

        fun toBusiness(t: TaskEntity): Task =
            Task(
                id = TaskId.from(t.id),
                description = TaskDescription.from(t.description),
                deadline = TaskDeadline.from(t.deadline),
                priority = Priority.toBusiness(t.priority)
            )
    }
}
