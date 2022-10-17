package com.stringconcat.todo.clean.architecture.rest.endpoints

import com.stringconcat.todo.clean.architecture.rest.API_V1_GET_IMPORTANT
import com.stringconcat.todo.clean.architecture.rest.dto.TaskResponse
import com.stringconcat.todo.clean.architecture.usecase.GetImportantTasksUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetImportantTasksEndpoint(val getImportantTasks: GetImportantTasksUseCase) {
    @GetMapping(path = [API_V1_GET_IMPORTANT])
    fun execute(): ResponseEntity<*> {
        return ResponseEntity.ok(getImportantTasks.process().map { TaskResponse.from(it) })
    }
}