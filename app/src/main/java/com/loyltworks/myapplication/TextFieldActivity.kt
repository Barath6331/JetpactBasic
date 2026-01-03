package com.loyltworks.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box {
                        val textField = remember { mutableStateOf("") }
                        TextField(
                            value = textField.value,
                            onValueChange = {
                                textField.value = it
                            },
                            placeholder = {
                                Text("enter value")
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Characters,
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    Toast.makeText(this@TextFieldActivity,"hello", Toast.LENGTH_LONG).show()
                                }
                            ),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Yellow,      // background when focused
                                unfocusedContainerColor = Color.LightGray, // background when not focused
                                cursorColor = Color.Red,                   // cursor color
                                focusedTextColor = Color.Black,            // text color
                                unfocusedTextColor = Color.DarkGray        // text color when unfocused
                            ),
                            leadingIcon = {
                                Icon(painter = painterResource(R.drawable.ic_launcher_foreground) , contentDescription = "")
                            },
                            trailingIcon = {
                                Icon(painter = painterResource(R.drawable.ic_launcher_background) , contentDescription = "")
                            }
                        )
                    }
                }
            }
        }
    }
}
