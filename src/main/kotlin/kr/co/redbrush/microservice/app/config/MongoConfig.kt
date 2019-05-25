package kr.co.redbrush.microservice.app.config

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.repository.AccountRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import javax.annotation.PostConstruct

private val logger = KotlinLogging.logger {}

@Configuration
class MongoConfig {
    @Autowired
    lateinit var accountRepository: AccountRepository

    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    @PostConstruct
    fun initData() {
        mongoOperations.collectionExists("Accounts").subscribe {
            if (it != true) {
                mongoOperations.createCollection("Accounts").subscribe {
                    logger.info { "Accounts collection created." }
                }
            } else {
                logger.info {"Accounts collections already exist." }
            }

            accountRepository.existsById("test").subscribe {
                if (it != true) {
                    accountRepository.save(Account("test", "test")).subscribe {
                        logger.info { "test account created." }
                    }
                } else {
                    logger.info { "test account already exist." }
                }
            }
        }
    }
}