package com.loyltworks.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "page1"
                    ) {
                        composable("page1") {
                            page1(navController)
                        }

                        composable("page2") {
                            page2(navController)
                        }

                        composable("page3") {
                            page3(navController)
                        }

                        composable("page4/{money}", arguments = listOf(navArgument("money") {
                            type = NavType.IntType
                        })) { backStackEntry ->
                            page4(navController, backStackEntry.arguments?.getInt("money"))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun page1(naveConroller: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Button(
            onClick = {
                naveConroller.navigate("page2")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(alignment = Alignment.Center)
                .background(color = colorResource(R.color.white))
                .clip(shape = RoundedCornerShape(15.dp))
        ) {
            Text("Page2")
        }
    }
}

@Composable
fun page2(naveConroller: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(15.dp))
    ) {
        Button(
            onClick = {
                naveConroller.navigate("page3")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(alignment = Alignment.Center)
                .background(color = colorResource(R.color.white))
                .clip(shape = RoundedCornerShape(15.dp))
        ) {
            Text("Page1")
        }
    }
}

@Composable
fun page3(naveConroller: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Button(
            onClick = {
                naveConroller.navigate("page4/10")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(alignment = Alignment.Center)
                .background(color = colorResource(R.color.white))
                .clip(shape = RoundedCornerShape(15.dp))
        ) {
            Text("Page4")
        }
    }
}

@Composable
fun page4(naveConroller: NavController, recivemoney: Int?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Column {
            Text(text = recivemoney.toString())

            Button(
                onClick = {
                    naveConroller.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = colorResource(R.color.white))
                    .clip(shape = RoundedCornerShape(15.dp))
            ) {
                Text("Page3")
            }
        }
    }
}
