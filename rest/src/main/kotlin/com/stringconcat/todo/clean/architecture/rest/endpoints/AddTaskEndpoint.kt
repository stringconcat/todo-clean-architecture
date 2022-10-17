package com.stringconcat.todo.clean.architecture.rest.endpoints

import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.domain.TaskDescription
import com.stringconcat.todo.clean.architecture.rest.API_V1_ADD_TASK
import com.stringconcat.todo.clean.architecture.rest.dto.TaskRequest
import com.stringconcat.todo.clean.architecture.rest.dto.TaskResponse
import com.stringconcat.todo.clean.architecture.usecase.CreateNewTaskUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AddTaskEndpoint(val createNewTask: CreateNewTaskUseCase) {
    @PostMapping(path = [API_V1_ADD_TASK])
    fun execute(@RequestBody request: TaskRequest): ResponseEntity<*> {

        val task = createNewTask.invoke(
            TaskDescription.from(request.description),
            TaskDeadline.from(request.deadline)
        )

        return ResponseEntity.ok(TaskResponse.from(task))
    }
}


