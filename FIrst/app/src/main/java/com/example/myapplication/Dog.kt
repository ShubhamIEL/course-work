package com.example.myapplication

class Dog (name: String)//parameter

//class Dog (val name: String)//property
 {
    init{
        bark(name)
    }
    fun bark(name: String){
        print("$name woof woof")
    }
}
fun main(){
    var daisy= Dog("Dasiy")
}