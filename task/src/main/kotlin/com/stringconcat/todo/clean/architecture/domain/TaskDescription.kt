package com.stringconcat.todo.clean.architecture.domain

data class TaskDescription internal constructor(private val value: String) {

    fun toStringValue() = value

    companion object {

        fun from(description: String): TaskDescription =
            if (description.isNotBlank()) {
                TaskDescription(description)
            } else {
                throw IllegalArgumentException("Invalid task name")
            }
    }
}

