package com.loyltworks.myapplication.navigation_demo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class DemoMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationMenu(
                        onNavigateToActivity = {
                            startActivity(Intent(this, SecondActivity::class.java))
                        },
                        onNavigateToCompose = {
                            startActivity(Intent(this, ComposeNavActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationMenu(
    onNavigateToActivity: () -> Unit,
    onNavigateToCompose: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Navigation Demo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = onNavigateToActivity,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Activity to Activity Navigation")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNavigateToCompose,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Jetpack Compose Page Navigation")
        }
    }
}
