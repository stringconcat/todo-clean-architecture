package com.stringconcat.todo.clean.architecture.persistance

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.persistance.model.TaskEntity
import com.stringconcat.todo.clean.architecture.persistance.repository.TaskRepository
import com.stringconcat.todo.clean.architecture.usecase.access.PersistTask
import org.springframework.stereotype.Component

@Component
class PersistTaskToDataBase(
    private val repository: TaskRepository
) : PersistTask {
    override fun persist(task: Task) {
        repository
            .save(TaskEntity.fromBusiness(task))
            .let { TaskEntity.toBusiness(it) }
    }
}