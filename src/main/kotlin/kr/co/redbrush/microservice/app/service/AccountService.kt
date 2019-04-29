package kr.co.redbrush.microservice.app.service

import kr.co.redbrush.microservice.app.data.Account
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AccountService {
    fun getAccount(id: String) : Mono<Account>
    fun createAccount(accountMono: Mono<Account>) : Mono<Account>
    fun updateAccount(id: String, accountMono: Mono<Account>) : Mono<*>
    fun deleteAccount(id: String)
    fun searchAccounts(idFilter: String) : Flux<Account>
}