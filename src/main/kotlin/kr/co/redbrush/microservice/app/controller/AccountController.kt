package kr.co.redbrush.microservice.app.controller

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class AccountController {
    @Autowired
    private lateinit var accountService: AccountService

    @GetMapping("/account/{id}")
    fun getAccount(@PathVariable id: String) : ResponseEntity<Mono<Account>> {
        val account = accountService.getAccount(id)

        return ResponseEntity(account, HttpStatus.OK)
    }

    @GetMapping("/accounts")
    fun getAccounts(@RequestParam(required = false, defaultValue = "") idFilter: String) = accountService.searchAccounts(idFilter)

    @PostMapping("/account")
    fun createAccount(@RequestBody accountMono : Mono<Account>) = ResponseEntity(accountService.createAccount(accountMono), HttpStatus.CREATED)

    @PutMapping("/account/{id}")
    fun updateAccount(@PathVariable id: String, @RequestBody accountMono: Mono<Account>): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND

        if (accountService.getAccount(id) != null) {
            accountService.updateAccount(id, accountMono)
            status = HttpStatus.ACCEPTED
        }

        return ResponseEntity(Unit, status)
    }

    @DeleteMapping("/account/{id}")
    fun deleteAccount(@PathVariable id: String): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND

        if (accountService.getAccount(id) != null) {
            accountService.deleteAccount(id)
            status = HttpStatus.OK
        }

        return ResponseEntity(Unit, status)
    }
}