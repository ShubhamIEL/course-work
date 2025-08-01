package com.example.myapplication

class BankAccount(var accHOlder: String,var bal:Double) {
    private val transactionHistory = mutableListOf<String>()

    fun deposit(amount: Double){
        bal+=amount
        transactionHistory.add("$accHOlder deposited Rs.$amount balance is Rs.$bal")
    }
    fun withdraw(amount: Double){
        if(amount<bal){
            bal-=amount
            transactionHistory.add("$accHOlder withdrawed Rs.$amount balance is Rs.$bal")
        }
        else{
            println("BALNCE IS LOW TO WITHDRAW")
        }
    }
    fun displayTransactionHistory(){
        println("TRANSACTON HISTORY:")
//        println(transactionHistory)
        for(item in transactionHistory){
            println(item)
        }
    }
}