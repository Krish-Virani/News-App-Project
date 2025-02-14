package com.example.myproject.screens.dialogue

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject.ui.theme.shadow


@Composable
fun LoginDialogue(onGoogleSignInClick:()->Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .shadow(
                    color = Color.DarkGray,
                    offsetX = (0).dp,
                    offsetY = (0).dp,
                    blurRadius = 36.dp
                ),
            shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(16.dp, 16.dp, 16.dp, bottom = 20.dp)
            ) {
                Text(
                    text = "Get Started",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 40.sp,
                        letterSpacing = 0.5.sp
                    )
                )
                Spacer(modifier = Modifier.padding(12.dp))
                Text(
                    text = "Register to experience world class services quickly !",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        letterSpacing = 0.5.sp
                    )
                )
                Spacer(modifier = Modifier.padding(12.dp))
                Button(
                    onClick = { onGoogleSignInClick() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF171A24),
                        disabledContentColor = Color.Black
                    ),
                    shape = ButtonDefaults.shape,
                    border = BorderStroke(2.dp, Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Image(imageVector = Icons.Default.Person, contentDescription = null)
                    Spacer(modifier = Modifier.padding(2.dp)
                        )
                    Text(
                        text = "Sign In"
                    )
                }
                Spacer(modifier = Modifier.padding(12.dp))
                Text(
                    text = "Already have an account? Log in",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14
                            .sp,
                        letterSpacing = 0.5.sp
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }


    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginDialoguePreview() {
//        LoginDialogue()
//}