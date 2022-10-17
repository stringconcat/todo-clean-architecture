package com.stringconcat.todo.clean.architecture.domain

interface PriorityProvider {
    fun calculatePriority(task: Task): Task.Priority
}
