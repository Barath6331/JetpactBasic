package com.loyltworks.myapplication

sealed class Navigations(val route : String) {

    object Login : Navigations("one/{id}"){
        fun createRoute(id:Int)= "one$id"
    }

    object Signup : Navigations("two/{id}"){
        fun createRoute(id:Int) = "two$id"
    }
}