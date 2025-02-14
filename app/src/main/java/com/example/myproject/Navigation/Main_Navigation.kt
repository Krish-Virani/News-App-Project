package com.example.myproject.Navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproject.presentation.home.HomeScreen
import com.example.myproject.screens.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation(
    navController: NavHostController,
    mainNavController: NavHostController = rememberNavController()
) {

    val isNavBarVisible = remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Toggle the visibility of the navigation bar
                    isNavBarVisible.value = !isNavBarVisible.value
                },
                //containerColor = Color.Yellow,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 16.dp),
                modifier=Modifier
                    .clip(shape = CircleShape)
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Open Menu")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,

    ) {
        Box(
            modifier = Modifier.background(Color.Black)
        ) {
            NavHost(
                navController = mainNavController,
                route = "MainNavigation",
                startDestination = "HomeScreen"
                ) {
                composable("HomeScreen") {
                    HomeScreen(mainNavController)
                }
                composable("ProfileScreen") {
                    ProfileScreen(mainNavController, navController)
                }
            }

            AnimatedVisibility(
                visible = isNavBarVisible.value,
                enter = expandHorizontally(
                    expandFrom = Alignment.CenterHorizontally
                ),
                exit = shrinkHorizontally(
                    // Overwrites the default animation with tween for this shrink animation.
                    animationSpec = tween(),
                    // Shrink towards the end (i.e. right edge for LTR, left edge for RTL). The default
                    // direction for the shrink is towards [Alignment.Start]
                    shrinkTowards = Alignment.CenterHorizontally,
                ) {
                    // Set the end width for the shrink animation to a quarter of the full width.
                    0
                },
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .safeContentPadding()
                    .padding(bottom = 16.dp)

            ) {
                Row(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(64.dp))
                        .height(56.dp) // Same height as the FAB
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    // Navigation Button 1
                    IconButton(onClick = {

                        mainNavController.navigate("HomeScreen")
                        isNavBarVisible.value = false // Hide the nav bar after selection
                    }) {
                        Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                    }
                    
                    Spacer(modifier = Modifier.padding(32.dp))

                    // Navigation Button 2
                    IconButton(onClick = {
                        mainNavController.navigate("ProfileScreen")

                    }) {
                        Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black)
                    }

                    // Add more buttons as needed
                }
            }
        }
    }
}