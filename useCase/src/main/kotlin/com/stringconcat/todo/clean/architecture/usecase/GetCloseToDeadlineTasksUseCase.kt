package com.stringconcat.todo.clean.architecture.usecase

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline

interface GetCloseToDeadlineTasksUseCase {
    fun process(deadline : TaskDeadline): List<Task>
}