package kr.co.redbrush.microservice.app.exception

class AccountExistException(override val message: String) : Exception(message)