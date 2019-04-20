package kr.co.redbrush.microservice.app.controller

import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class ErrorHandler {
    // TODO : Change servlet based exception handler with WebFlux
    /*
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseExceptionHandler(servletRequest: HttpServletRequest, exception: Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("JSON Error", exception.message ?: "Invalid Json"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AccountNotFoundException::class)
    fun accountNotFoundExceptionHandler(servletRequest: HttpServletRequest, exception: Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("Account not found", exception.message!!), HttpStatus.NOT_FOUND)
    }
    */
}