package kr.co.redbrush.microservice.app.handler

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Component
class AccountHandler {
    fun get(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ok().body(Account("test", "password").toMono(), Account::class.java)
    }
}