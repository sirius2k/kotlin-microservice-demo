package kr.co.redbrush.microservice.app.service

import kr.co.redbrush.microservice.app.data.Account
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AccountService {
    fun getAccount(id: String) : Mono<Account>?
    fun createAccount(account: Account)
    fun updateAccount(id: String, account: Account)
    fun deleteAccount(id: String)
    fun searchAccounts(idFilter: String) : Flux<Account>
}