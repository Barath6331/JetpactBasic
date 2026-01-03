package com.loyltworks.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class RowColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(contentAlignment = Alignment.Center){
                        Column {
                            Row {
                                Text(
                                    "1",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(1f)
                                )
                                Text(
                                    "2",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(1f)
                                )
                                Text(
                                    "3",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(1f)
                                )
                                Text(
                                    "4",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(1f)
                                )
                                Text(
                                    "5",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(1f)
                                )
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text("1")
                                Text("2")
                                Text("3")
                                Text("4")
                                Text("5")
                            }
                            Row {
                                Text("1")
                                Text("2")
                                Text("3")
                                Text("4")
                                Text("5")
                            }
                        }
                    }
                }
            }
        }
    }
}