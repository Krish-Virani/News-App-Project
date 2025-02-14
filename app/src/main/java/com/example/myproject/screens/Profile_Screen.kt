package com.example.myproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun ProfileScreen(mainNavController: NavController, navController: NavController ) {

    val user = Firebase.auth.currentUser

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color.Blue, Color.Black),
                    start = Offset(0f, 0f), // Starting point of the gradient
                    end = Offset(0f, 700f) // Ending point of the gradient
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 138.dp, 16.dp, 16.dp)

        ) {
            // Profile Image with shadow
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF1F1F1F))
                    .shadow(elevation = 8.dp, shape = CircleShape)
            ) {
                if (user != null) {
                    AsyncImage(
                        model = user.photoUrl,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Name with shadow
            if (user != null) {
                user.displayName?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            shadow = Shadow(
                                color = Color(0xFF333333),
                                blurRadius = 4f
                            )
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Email
            if (user != null) {
                user.email?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Country Card with shadow
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F1F)),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Country: India",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(48.dp))

            Button(onClick = {
                Firebase.auth.signOut()
                navController.navigate("EntryScreen"){
                    // Clear the back stack to avoid returning to MainNavigation
                    popUpTo("RootNavigation") { inclusive = true }
                }
            }) {
                Text(text = "Log-out")
            }
        }




    }


}