package kr.co.redbrush.microservice.app.router

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono

@Component
class AccountRouter {
    @Bean
    fun accountRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/account".nest {
                GET("/") {
                    ok().body(Account("test", "password").toMono(), Account::class.java)
                }
            }
        }
    }
}