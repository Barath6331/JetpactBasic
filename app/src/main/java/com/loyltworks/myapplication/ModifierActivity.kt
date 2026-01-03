package com.loyltworks.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                /*Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.qr),
                            contentDescription = "",
                            modifier = Modifier
                                .size(100.dp)
                                .border(width = 2.dp, color = Color.Black),
                            contentScale = ContentScale.Crop
                        )
                    }*/

                    Box(modifier = Modifier.padding(innerPadding)) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                                .background(
                                    color = Color.Black
                                )
                        ) {

                        }

                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .width(50.dp)
                                .background(
                                    color = Color.Red
                                )
                                .align(Alignment.Center)
                        ) {

                        }

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = Color.Green
                                )
                        ) {

                        }

                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color.Green
                                )
                                .align(Alignment.Center)
                        ) {
                            Text(text = "barath")
                        }
                    }
                }
            }
        }
    }
}