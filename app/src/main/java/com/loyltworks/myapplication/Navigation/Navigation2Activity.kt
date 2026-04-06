package com.loyltworks.myapplication.Navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.loyltworks.myapplication.Navigation.ui.theme.MyApplicationTheme

class Navigation2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ScreenOne.route
                    ) {
                        composable(Screen.ScreenOne.route) {
                            ScreenOne(navController)
                        }

                        composable(Screen.ScreenTwo.route) {
                            ScreenTwo(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenOne(navController: NavController) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Button(onClick = { navController.navigate(Screen.ScreenTwo.createRoute(0)) }) {
            Text("Second page")
        }

    }
}

@Composable
fun ScreenTwo(navController: NavController) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Button(onClick = { navController.popBackStack() }) {
            Text("First page")
        }

    }
}
