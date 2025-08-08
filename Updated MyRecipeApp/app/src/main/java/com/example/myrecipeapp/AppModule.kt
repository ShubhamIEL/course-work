package com.example.myrecipeapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Tells Hilt this is a module for providing dependencies
@Module
// Tells Hilt to make these dependencies available for the entire app's lifecycle
@InstallIn(SingletonComponent::class)
object AppModule {

    // Teaches Hilt how to create a Retrofit instance
    @Provides
    // Ensures only one instance of Retrofit is ever created
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // THIS IS THE FUNCTION THE ERROR IS ASKING FOR
    // It teaches Hilt how to create an ApiService instance
    @Provides
    // Ensures only one instance of ApiService is ever created
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        // Hilt knows how to provide Retrofit from the function above,
        // so it can pass it in as a parameter here.
        return retrofit.create(ApiService::class.java)
    }
}