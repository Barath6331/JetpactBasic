

package com.loyltworks.myapplication

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class SignupActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            // 🔥 Single source of truth
            var username by rememberSaveable { mutableStateOf("") }
            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            var errorMessage by remember { mutableStateOf("") }

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.darkBlack)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {

                        Spacer(Modifier.height(40.dp))

                        Text(
                            text = "Sign Up",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.white)
                        )

                        Spacer(Modifier.height(20.dp))

                        Text(
                            text = "Create an account for free",
                            color = colorResource(R.color.white)
                        )

                        // 🔥 Fields
                        InputField(
                            label = "Name",
                            value = username,
                            onValueChange = { username = it },
                            isValid = username.length > 3
                        )

                        InputField(
                            label = "Email",
                            value = email,
                            onValueChange = { email = it },
                            isValid = Patterns.EMAIL_ADDRESS.matcher(email).matches(),
                            keyboardType = KeyboardType.Email
                        )

                        InputField(
                            label = "Password",
                            value = password,
                            onValueChange = { password = it },
                            isValid = password.length > 3,
                            isPassword = true
                        )

                        Spacer(Modifier.height(20.dp))

                        // 🔴 Error Text
                        if (errorMessage.isNotEmpty()) {
                            Text(
                                text = errorMessage,
                                color = Color.Red
                            )
                        }

                        Spacer(Modifier.height(20.dp))

                        // 🔥 Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            colorResource(R.color.liteBlue),
                                            colorResource(R.color.darkBlue)
                                        )
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable {

                                    // 🔥 Validation
                                    errorMessage = when {
                                        username.isEmpty() -> "Username required"
                                        username.length < 3 -> "Username too short"
                                        email.isEmpty() -> "Email required"
                                        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email"
                                        password.isEmpty() -> "Password required"
                                        password.length < 3 -> "Password too short"
                                        else -> ""
                                    }

                                    if (errorMessage.isEmpty()) {
                                        // ✅ SUCCESS
                                        println("Signup Success: $username $email $password")
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "SIGN UP",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isValid: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {

    Text(
        text = label,
        color = colorResource(R.color.white),
        modifier = Modifier.padding(top = 16.dp)
    )

    Spacer(Modifier.height(6.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                colorResource(R.color.lightBlack),
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 2.dp,
                brush = Brush.verticalGradient(
                    if (isValid) listOf(
                        colorResource(R.color.liteBlue),
                        colorResource(R.color.darkBlue)
                    )
                    else listOf(
                        colorResource(R.color.mediumBlack),
                        colorResource(R.color.mediumBlack)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        if (value.isEmpty()) {
            Text(text = "Enter $label", color = Color.Gray)
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp
            ),
            cursorBrush = SolidColor(Color.White),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            ),
            visualTransformation = if (isPassword)
                PasswordVisualTransformation()
            else VisualTransformation.None
        )
    }
} 