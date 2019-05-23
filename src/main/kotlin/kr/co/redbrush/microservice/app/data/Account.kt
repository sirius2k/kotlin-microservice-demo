package kr.co.redbrush.microservice.app.data

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Accounts")
data class Account(var id: String = "", var password: String = "", var telephone: Telephone? = null)