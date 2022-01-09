package com.finalProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class FinalProjectApplication

fun main(args: Array<String>) {
	runApplication<FinalProjectApplication>(*args)

	print("test")
}
