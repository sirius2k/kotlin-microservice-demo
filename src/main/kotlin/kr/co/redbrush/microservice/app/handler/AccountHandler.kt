package kr.co.redbrush.microservice.app.handler

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import java.net.URI

@Component
class AccountHandler(val accountService: AccountService) {
    fun get(serverRequest: ServerRequest) =
            accountService.getAccount(serverRequest.pathVariable("id"))
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())

    fun create(serverRequest: ServerRequest) =
            accountService.createAccount(serverRequest.bodyToMono()).flatMap {
                created(URI.create("/funcitonal/account/${it.id}")).build()
            }

    fun search(serverRequest: ServerRequest) =
            ok().body(
                    accountService.searchAccounts(serverRequest.queryParam("nameFilter").orElse("")),
                    Account::class.java
            )
}