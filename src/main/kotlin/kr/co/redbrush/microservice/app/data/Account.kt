package kr.co.redbrush.microservice.app.data

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Account(var id: String = "", var password: String = "", var telephone: Telephone? = null)