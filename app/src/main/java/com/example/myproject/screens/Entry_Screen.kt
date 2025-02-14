package com.example.myproject.screens

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myproject.screens.dialogue.LoginDialogue
import com.example.myproject.R
import com.example.myproject.signin.GoogleSignInViewModel
import kotlinx.coroutines.delay

@Composable
fun EntryScreen(googleSignInViewModel: GoogleSignInViewModel, navController: NavController, context: Context) {


    val offsetY = remember { Animatable(300f) }

    var showDialog by remember { mutableStateOf(false) }

    // Show the dialog after a 1500ms delay
    LaunchedEffect(Unit) {
        delay(1500) // Wait for 1500ms
        showDialog = true
    }

    LaunchedEffect(Unit) {
        delay(1500) // Delay before animation starts (1 second)
        offsetY.animateTo(
            targetValue = 150f, // Move image by 300dp vertically
            animationSpec = tween(durationMillis = 500) // Animation duration
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF0A0A0A))

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(y = offsetY.value.dp)
                .size(250.dp)
                
        )
        Spacer(modifier = Modifier.padding(100.dp))
        AnimatedVisibility(
            visible = showDialog,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight }, // Start from below the screen
                animationSpec = tween(durationMillis = 500) // Duration of the slide animation
            )
        )
        {

            LoginDialogue { googleSignInViewModel.handleGoogleSignIn(context, navController) }

        }
    }
}

