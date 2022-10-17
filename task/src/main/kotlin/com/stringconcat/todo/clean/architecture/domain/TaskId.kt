package com.stringconcat.todo.clean.architecture.domain

import java.util.*

class TaskId internal constructor(private val value: UUID? = UUID.randomUUID()) {

    fun toUUIDValue() = value

    companion object {
        fun from(id: UUID): TaskId = TaskId(id)
    }
}