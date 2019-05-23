package kr.co.redbrush.microservice.app.config

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import javax.annotation.PostConstruct

class DatabaseInitializer {
    @Autowired
    lateinit var accountRepository: AccountRepository

    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    @PostConstruct
    fun initData() {
        mongoOperations.collectionExists("Accounts").subscribe {
            if (it != true) {
                mongoOperations.createCollection("Accounts").subscribe {
                    println("Accounts collection created")
                }
            } else {
                println("Account collections already exist")
            }

            accountRepository.save(Account("test", "test")).subscribe {
                println("Test account created")
            }
        }
    }
}