package com.loyltworks.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class DraggableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize().padding(top = 25.dp).background(Color.Black)) {
                    val d = LocalDensity.current
                    var offsetx by remember { mutableStateOf(0f) }
                    var offsety by remember { mutableStateOf(0f) }
                    Box() {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .offset(
                                    (offsetx/d.density).dp,
                                    (offsety/d.density).dp
                                )
                                .background(colorResource(R.color.purple_200))
                                .pointerInput(Unit){
                                    detectDragGestures { change, dragAmount ->
                                        change.consumeAllChanges()
                                        offsetx += dragAmount.x
                                        offsety += dragAmount.y
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "1",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.white)
                            )
                        }
                    }
                }
            }
        }
    }
}
