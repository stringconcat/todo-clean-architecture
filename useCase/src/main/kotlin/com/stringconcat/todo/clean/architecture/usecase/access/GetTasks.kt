package com.stringconcat.todo.clean.architecture.usecase.access

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline

interface GetTasks {
    fun findAllByPriority(priority: Task.Priority): List<Task>
    fun findAllByDeadline(deadline: TaskDeadline): List<Task>
}