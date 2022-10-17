package com.stringconcat.todo.clean.architecture.usecase

import com.stringconcat.todo.clean.architecture.domain.Task

interface GetImportantTasksUseCase {
    fun process() : List<Task>
}