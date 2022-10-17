package com.stringconcat.todo.clean.architecture.usecase

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.domain.TaskDescription

interface CreateNewTaskUseCase {
    fun invoke(description: TaskDescription, deadline: TaskDeadline): Task
}