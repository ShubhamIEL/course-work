package com.example.myrecipeapp

import retrofit2.http.GET

// This interface is the blueprint for Retrofit and Hilt. It must exist.
interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}