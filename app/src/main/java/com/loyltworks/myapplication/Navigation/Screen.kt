package com.loyltworks.myapplication.Navigation

sealed class Screen(val route: String) {

    object ScreenOne : Screen("one/{id}") {
        fun createRoute(id: Int) = "one/$id"
    }

    object ScreenTwo : Screen("two/{id}") {
        fun createRoute(id: Int) = "two/$id"
    }
}