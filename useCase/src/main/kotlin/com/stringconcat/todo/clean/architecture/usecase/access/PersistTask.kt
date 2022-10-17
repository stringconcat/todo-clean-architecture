package com.stringconcat.todo.clean.architecture.usecase.access

import com.stringconcat.todo.clean.architecture.domain.Task

interface PersistTask {
    fun persist(task: Task)
}