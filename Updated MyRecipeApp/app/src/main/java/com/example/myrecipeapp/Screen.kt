package com.example.myrecipeapp

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    data object RecipeScreen : Screen

    @Serializable
    data class DetailScreen(val category: Category) : Screen
}