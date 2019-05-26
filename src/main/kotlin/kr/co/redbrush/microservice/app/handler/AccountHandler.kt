package kr.co.redbrush.microservice.app.handler

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.data.ErrorResponse
import kr.co.redbrush.microservice.app.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.onErrorResume
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
            }.onErrorResume(Exception::class) {
                badRequest().body(fromObject(ErrorResponse("Error creating account", it.message ?: "error")))
            }

    fun update(serverRequest: ServerRequest) =
            accountService.updateAccount(serverRequest.pathVariable("id"), serverRequest.bodyToMono()).flatMap {
                accepted().build()
            }.onErrorResume(Exception::class) {
                badRequest().body(fromObject(ErrorResponse("Error updating account", it.message ?: "error")))
            }

    fun delete(serverRequest: ServerRequest) =
            accountService.deleteAccount(serverRequest.pathVariable("id")).flatMap {
                if (it) ok().build()
                else status(HttpStatus.NOT_FOUND).build()
            }

    fun search(serverRequest: ServerRequest) =
            ok().body(
                    accountService.searchAccounts(serverRequest.queryParam("nameFilter").orElse("")),
                    Account::class.java
            )
}