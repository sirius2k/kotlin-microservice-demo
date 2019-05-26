package kr.co.redbrush.microservice.app.repository

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.data.Telephone
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import javax.annotation.PostConstruct

@Repository
class AccountRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val initialAccounts = listOf(
                Account("Kotlin", "password"),
                Account("Spring", "password"),
                Account("Microservic", "password", Telephone("+82", "010-1234-5678"))
        )
    }

    @PostConstruct
    fun initRepository() = initialAccounts.map(Account::toMono).map(this::create).map(Mono<Account>::subscribe)

    fun create(account: Mono<Account>) = template.save(account)
    fun findById(id: String) = template.findById<Account>(id)
    fun findAllById(idFilter: String) = template.find<Account>(Query(where("name").regex(".*$idFilter.*", "i")))
    fun deleteById(id: String) = template.remove(Query(where("_id").isEqualTo(id)), "Accounts")
}