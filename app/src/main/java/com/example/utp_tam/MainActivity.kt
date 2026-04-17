package com.example.utp_tam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.utp_tam.ui.theme.UTP_TAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTP_TAMTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") { 
                                HomePage(
                                    onBookNowClick = { navController.navigate("booking") },
                                    onMoreClick = { navController.navigate("more") }
                                ) 
                            }
                            composable("booking") { 
                                BookingPage(
                                    onBackClick = { navController.popBackStack() },
                                    onMoreClick = { navController.navigate("more") }
                                )
                            }
                            composable("more") { 
                                MorePage(onHomeClick = { navController.popBackStack() }) 
                            }
                        }
                    }
                }
            }
        }
    }
}

