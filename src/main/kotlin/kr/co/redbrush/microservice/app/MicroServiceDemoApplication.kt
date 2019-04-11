package kr.co.redbrush.microservice.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroServiceDemoApplication

fun main(args: Array<String>) {
	runApplication<MicroServiceDemoApplication>(*args)
}
