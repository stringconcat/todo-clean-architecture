package com.stringconcat.todo.clean.architecture.domain

import javax.inject.Named

@Named
class TaskGenerator(
    private val priorityProvider: PriorityProvider,
) {

    fun generate(
        description: TaskDescription,
        deadline: TaskDeadline
    ): Task =
        Task(
            description = description,
            deadline = deadline,
        ).also {
            val priority = priorityProvider.calculatePriority(it)
            it.changePriority(priority)
        }
}