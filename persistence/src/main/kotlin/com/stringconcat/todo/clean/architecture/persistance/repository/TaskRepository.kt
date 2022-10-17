package com.stringconcat.todo.clean.architecture.persistance.repository

import com.stringconcat.todo.clean.architecture.persistance.model.TaskEntity
import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime
import java.util.*

interface TaskRepository : CrudRepository<TaskEntity, UUID> {
    fun findAllByPriority(priority: TaskEntity.Priority): List<TaskEntity>
    fun findAllByDeadline(deadline: LocalDateTime): List<TaskEntity>
}