package com.example.myrecipeapp

import kotlinx.serialization.Serializable // Make sure this import is present

// Add @Serializable. You can remove @Parcelize and : Parcelable.
@Serializable
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

// This class does not need to be changed
data class CategoriesResponse(
    val categories: List<Category>
)