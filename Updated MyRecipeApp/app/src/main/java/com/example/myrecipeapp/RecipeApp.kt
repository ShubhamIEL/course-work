package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = hiltViewModel()
    val viewState by recipeViewModel.recipeState.collectAsStateWithLifecycle()

    NavHost(navController = navController, startDestination = Screen.RecipeScreen) {
        composable<Screen.RecipeScreen> {
            RecipeScreen(
                viewState = viewState,
                navigateToDetail = { category ->
                    navController.navigate(Screen.DetailScreen(category = category))
                }
            )
        }
        composable<Screen.DetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Screen.DetailScreen>()
            CategoryDetailScreen(category = args.category)
        }
    }
}