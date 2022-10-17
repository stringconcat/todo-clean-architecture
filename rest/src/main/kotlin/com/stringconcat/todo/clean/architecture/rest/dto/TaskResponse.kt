package com.stringconcat.todo.clean.architecture.rest.dto

import com.stringconcat.todo.clean.architecture.domain.Task
import java.time.LocalDateTime
import java.util.*

data class TaskResponse(
    val id: UUID,
    val description: String,
    val deadline: LocalDateTime,
    val priority: String
) {

    companion object {
        fun from(task: Task): TaskResponse =
            TaskResponse(
                id = task.id.toUUIDValue()!!,
                description = task.description.toStringValue(),
                deadline = task.deadline.toLocalDateTimeValue(),
                priority = task.priority.toString()
            )
    }
}