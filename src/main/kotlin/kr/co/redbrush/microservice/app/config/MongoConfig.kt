package kr.co.redbrush.microservice.app.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class MongoConfig {
    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    @PostConstruct
    fun initData() {
        mongoOperations.createCollection("Accounts").subscribe {
            println("Account collections initialize.")
        }
    }
}