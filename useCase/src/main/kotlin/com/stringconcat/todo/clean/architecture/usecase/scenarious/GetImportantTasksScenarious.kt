package com.stringconcat.todo.clean.architecture.usecase.scenarious

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.usecase.GetImportantTasksUseCase
import com.stringconcat.todo.clean.architecture.usecase.access.GetTasks
import javax.inject.Named

@Named
class GetImportantTasksScenarious(
    private val getTasks: GetTasks
) : GetImportantTasksUseCase {

    override fun process(): List<Task> {
        return getTasks.findAllByPriority(Task.Priority.HIGH)
    }
}