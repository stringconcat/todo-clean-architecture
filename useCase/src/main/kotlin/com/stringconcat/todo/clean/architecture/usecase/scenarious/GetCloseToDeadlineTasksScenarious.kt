package com.stringconcat.todo.clean.architecture.usecase.scenarious

import com.stringconcat.todo.clean.architecture.domain.Task
import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.usecase.GetCloseToDeadlineTasksUseCase
import com.stringconcat.todo.clean.architecture.usecase.access.GetTasks
import javax.inject.Named

@Named
class GetCloseToDeadlineTasksScenarious(
    private val getTasks: GetTasks
) : GetCloseToDeadlineTasksUseCase {
    override fun process(deadline: TaskDeadline): List<Task> {
        return getTasks.findAllByDeadline(deadline)
    }
}