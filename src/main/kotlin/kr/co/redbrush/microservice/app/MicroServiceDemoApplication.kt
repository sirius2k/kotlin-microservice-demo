package kr.co.redbrush.microservice.app

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class MicroServiceDemoApplication

fun main(args: Array<String>) {
	runApplication<MicroServiceDemoApplication>(*args)
}
