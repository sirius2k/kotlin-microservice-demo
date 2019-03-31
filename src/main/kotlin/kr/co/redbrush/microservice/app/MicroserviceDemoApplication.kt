package kr.co.redbrush.microservice.app

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceDemoApplication {
	companion object {
	    val testAccount = Account("test", "1234");
	}
}

fun main(args: Array<String>) {
	runApplication<MicroserviceDemoApplication>(*args)
}
