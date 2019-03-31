package kr.co.redbrush.microservice.app

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MicroserviceDemoApplication {
	companion object {
	    val testAccount = Account("test", "1234")
	}

	@Bean
	fun account() = testAccount
}

fun main(args: Array<String>) {
	runApplication<MicroserviceDemoApplication>(*args)
}
