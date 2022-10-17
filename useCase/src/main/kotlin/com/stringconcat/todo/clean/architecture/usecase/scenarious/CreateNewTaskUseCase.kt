package com.stringconcat.todo.clean.architecture.usecase.scenarious

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.domain.TaskDescription
import com.stringconcat.todo.clean.architecture.domain.TaskGenerator
import com.stringconcat.todo.clean.architecture.usecase.CreateNewTaskUseCase
import com.stringconcat.todo.clean.architecture.usecase.access.PersistTask
import javax.inject.Named

@Named
class CreateNewTaskScenarious(
    private val persistTask: PersistTask,
    private val taskGenerator: TaskGenerator
) : CreateNewTaskUseCase {
    override operator fun invoke(
        description: TaskDescription, deadline: TaskDeadline
    ): Task {

        val task = taskGenerator.generate(
            description = description,
            deadline = deadline,
        )

        persistTask.persist(task)

        return task
    }
}