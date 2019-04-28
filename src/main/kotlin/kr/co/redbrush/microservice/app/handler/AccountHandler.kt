package kr.co.redbrush.microservice.app.handler

import kr.co.redbrush.microservice.app.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.ServerResponse.status

@Component
class AccountHandler(val accountService: AccountService) {
    fun get(serverRequest: ServerRequest) =
            accountService.getAccount(serverRequest.pathVariable("id"))
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())
}