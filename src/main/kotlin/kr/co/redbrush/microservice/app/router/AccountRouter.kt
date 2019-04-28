package kr.co.redbrush.microservice.app.router

import kr.co.redbrush.microservice.app.handler.AccountHandler
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router

@Component
class AccountRouter(private val accountHandler: AccountHandler) {
    @Bean
    fun accountRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/account".nest {
                GET("/{id}", accountHandler::get)
            }
        }
    }
}