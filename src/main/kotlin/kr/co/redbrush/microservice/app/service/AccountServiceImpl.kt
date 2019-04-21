package kr.co.redbrush.microservice.app.service

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.data.Telephone
import org.springframework.stereotype.Service
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Service
class AccountServiceImpl : AccountService {
    companion object {
        val initialAccounts = arrayOf(
            Account("test", "1234", Telephone("+82", "12345678")),
            Account("test1", "1234", Telephone("+82", "98764321")),
            Account("test2", "1234")
        )
    }
    val accounts = ConcurrentHashMap<String, Account>(initialAccounts.associateBy(Account::id))

    override fun getAccount(id: String) = accounts[id]?.toMono()

    override fun createAccount(account: Account) {
        accounts[account.id] = account
    }

    override fun updateAccount(id: String, account: Account) {
        deleteAccount(id)
        createAccount(account)
    }

    override fun deleteAccount(id: String) {
        accounts.remove(id)
    }

    override fun searchAccounts(idFilter: String): List<Account> =
        accounts.filter {
            it.value.id.contains(idFilter, true)
        }.map(Map.Entry<String, Account>::value).toList()
}