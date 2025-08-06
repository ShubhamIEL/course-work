package com.example.myrecipeapp

import okhttp3.Route

sealed class Screen(val route: String) {
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}