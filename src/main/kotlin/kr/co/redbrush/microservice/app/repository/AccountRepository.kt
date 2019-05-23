package kr.co.redbrush.microservice.app.repository

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AccountRepository : ReactiveCrudRepository<Account, String>