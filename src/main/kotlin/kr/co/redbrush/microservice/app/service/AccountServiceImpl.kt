package kr.co.redbrush.microservice.app.service

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AccountServiceImpl : AccountService {
    @Autowired
    lateinit var accountRepository: AccountRepository

    override fun getAccount(id: String) = accountRepository.findById(id)

    override fun createAccount(accountMono: Mono<Account>) = accountRepository.create(accountMono)

    override fun updateAccount(id: String, accountMono: Mono<Account>): Mono<Account> {
        deleteAccount(id)

        return createAccount(accountMono)
    }

    override fun deleteAccount(id: String) = accountRepository.deleteById(id).map { it.deletedCount > 0 }

    override fun searchAccounts(idFilter: String) = accountRepository.findAllById(idFilter)
}