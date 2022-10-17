package com.stringconcat.todo.clean.architecture.rest.dto

data class TaskRequest(
    val description: String,
    val deadline: Long,
)