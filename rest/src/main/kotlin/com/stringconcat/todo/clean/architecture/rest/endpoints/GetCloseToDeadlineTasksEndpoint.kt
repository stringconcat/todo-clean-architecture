package com.stringconcat.todo.clean.architecture.rest.endpoints

import com.stringconcat.todo.clean.architecture.domain.TaskDeadline
import com.stringconcat.todo.clean.architecture.rest.API_V1_GET_CLOSE_TO_DEADLINE
import com.stringconcat.todo.clean.architecture.rest.dto.TaskResponse
import com.stringconcat.todo.clean.architecture.usecase.GetCloseToDeadlineTasksUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

class GetCloseToDeadlineTasksEndpoint(val getCloseToDeadlineTasks: GetCloseToDeadlineTasksUseCase) {
    @GetMapping(path = [API_V1_GET_CLOSE_TO_DEADLINE])
    fun execute(@PathVariable("deadline") deadline: Long): ResponseEntity<*> {
        return ResponseEntity.ok(
            getCloseToDeadlineTasks.process(TaskDeadline.from(deadline))
                .map { TaskResponse.from(it) })
    }
}