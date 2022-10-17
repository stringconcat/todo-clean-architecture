package com.stringconcat.todo.clean.architecture.domain

import java.time.LocalDateTime
import java.time.ZoneOffset

class TaskDeadline internal constructor(private val value: LocalDateTime) {

    fun toLocalDateTimeValue() = value

    companion object {

        fun from(deadline: LocalDateTime): TaskDeadline = TaskDeadline(deadline)

        fun from(deadline: Long): TaskDeadline = TaskDeadline(
            LocalDateTime.ofEpochSecond(deadline, 0, ZoneOffset.UTC)
        )
    }
}

