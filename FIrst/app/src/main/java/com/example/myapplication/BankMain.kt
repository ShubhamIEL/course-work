package com.example.myapplication

class BankMain {
}
fun main(){
    val denBankAccount = BankAccount("Denis",1300.00)
    println(denBankAccount.accHOlder)
    println(denBankAccount.bal)
    denBankAccount.deposit(1200.00)
    denBankAccount.withdraw(100.00)
    denBankAccount.displayTransactionHistory()
}