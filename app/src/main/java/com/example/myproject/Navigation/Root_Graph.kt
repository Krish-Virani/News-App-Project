package com.example.myproject.Navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myproject.screens.EntryScreen
import com.example.myproject.signin.GoogleSignInViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun RootGraph(navController: NavHostController) {
    val context = LocalContext.current
    val googleSignInViewModel = GoogleSignInViewModel()

    NavHost(navController = navController, route = "RootNavigation", startDestination = if(Firebase.auth.currentUser==null)"EntryScreen" else "MainNavigation") {
        composable(
            "EntryScreen",
            exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
                )
            }
        ) { EntryScreen(googleSignInViewModel,navController, context) }

        composable("MainNavigation"){
            MainNavigation(navController)
        }


    }
}