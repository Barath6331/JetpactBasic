package com.loyltworks.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.darkBlack)
                ) {
                    var username by rememberSaveable { mutableStateOf("") }
                    var password by rememberSaveable { mutableStateOf("") }

                    var error by remember { mutableStateOf("") }

                    Box(
                        modifier = Modifier
                            .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
                    ) {
                        Column() {
                            Text(
                                text = "Welcome Back!",
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                                    color = colorResource(R.color.white)
                                )
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Sign in to continue",
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                                    fontSize = 15.sp,
                                    color = colorResource(R.color.white)
                                )
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            InputFeilds(
                                lable = "UserName",
                                value = username,
                                onValueChange = { username = it },
                                keyboardType = KeyboardType.Text,
                                isPassword = false
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            InputFeilds(
                                lable = "Password",
                                value = password,
                                onValueChange = { password = it },
                                keyboardType = KeyboardType.Password,
                                isPassword = true
                            )

                            if (error.isNotEmpty()) {
                                Text(
                                    text = error,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                                        color = colorResource(R.color.white)
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(40.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                colorResource(R.color.liteBlue),
                                                colorResource(R.color.darkBlue)
                                            )
                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clickable {
                                        error = when {
                                            username.isEmpty() -> "Please enter username"
                                            password.isEmpty() -> "Please enter password"
                                            else -> ""
                                        }

                                        if (error.isEmpty()) {
                                            Toast.makeText(
                                                this@LoginActivity,
                                                "successfull",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
                                        }
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Signin",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                                        color = colorResource(R.color.white)
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InputFeilds(
    lable: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    isPassword: Boolean,
) {

    Text(
        text = lable,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            color = colorResource(R.color.white)
        )
    )

    Spacer(
        modifier = Modifier.height(
            15.dp
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = colorResource(R.color.lightBlack),
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 2.dp,
                brush = Brush.verticalGradient(
                    listOf(
                        colorResource(R.color.liteBlue),
                        colorResource(R.color.darkBlue)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        if (value.isEmpty()) {
            Text(
                text = "Enter $lable",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    color = colorResource(R.color.liteBlue)
                )
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                color = colorResource(R.color.white)
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
