package com.stringconcat.todo.clean.architecture.persistance

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.persistance.model.TaskEntity
import com.stringconcat.todo.clean.architecture.persistance.repository.TaskRepository
import com.stringconcat.todo.clean.architecture.usecase.access.GetTasks
import org.springframework.stereotype.Component

@Component
class GetTasksFromRepository(
    private val repository: TaskRepository
) : GetTasks {
    override fun findAllByPriority(priority: Task.Priority): List<Task> =
        repository
            .findAllByPriority(TaskEntity.Priority.fromBusiness(priority))
            .map { t -> TaskEntity.toBusiness(t) }.toList()

    override fun findAllByDeadline(deadline: TaskDeadline): List<Task> =
        repository
            .findAllByDeadline(deadline.toLocalDateTimeValue())
            .map { t -> TaskEntity.toBusiness(t) }.toList()

}