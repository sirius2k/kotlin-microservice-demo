package kr.co.redbrush.microservice.app.controller

import com.fasterxml.jackson.core.JsonParseException
import kr.co.redbrush.microservice.app.data.ErrorResponse
import kr.co.redbrush.microservice.app.exception.AccountNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseExceptionHandler(servletRequest: HttpServletRequest, exception: Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("JSON Error", exception.message ?: "Invalid Json"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AccountNotFoundException::class)
    fun accountNotFoundExceptionHandler(servletRequest: HttpServletRequest, exception: Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("Account not found", exception.message!!), HttpStatus.NOT_FOUND)
    }
}