package kr.co.redbrush.microservice.app.service

import kr.co.redbrush.microservice.app.data.Account

interface AccountService {
    fun getAccount(id: String) : Account?
    fun createAccount(account: Account)
    fun updateAccount(id: String, account: Account)
    fun deleteAccount(id: String)
    fun searchAccounts(idFilter: String) : List<Account>
}