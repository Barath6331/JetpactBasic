package com.loyltworks.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class TextActivity : ComponentActivity() {

    private val textStyle = TextStyle(
        color = Color.Black,
        fontSize = 20.sp,
        shadow = Shadow(
            color = Color.Blue,
            offset = Offset(12f,12f),
            blurRadius = 12f,
        ),
        fontFamily = FontFamily(Font(R.font.montserrat_bold))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Textshow(
                        name = "barth",
                        modifier = Modifier.padding(innerPadding),
                        style = textStyle
                    )
                }
            }
        }
    }
}

@Composable
fun Textshow(name: String, modifier: Modifier = Modifier,style: TextStyle) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = style
    )
}