package com.stringconcat.todo.clean.architecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(value = ["com.stringconcat.todo.clean.architecture"])
class PeopleApplication

fun main(args: Array<String>) {
	runApplication<PeopleApplication>(*args)
}
