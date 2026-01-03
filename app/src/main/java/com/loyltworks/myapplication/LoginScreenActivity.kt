package com.loyltworks.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class LoginScreenActivity : ComponentActivity() {

    val passwordFocusRequester = FocusRequester()
    val password = mutableStateOf("")
    val username = mutableStateOf("")

    private val textStyle = TextStyle(
        color = Color.Gray,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Column {
                            IconButton(
                                onClick = {
                                    Toast.makeText(
                                        this@LoginScreenActivity,
                                        "Pressed Back button",
                                        Toast.LENGTH_LONG
                                    ).show()
                                },
                                Modifier.size(50.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.back),
                                    contentDescription = ""
                                )
                            }

                            Text(
                                text = "Welcome Back!",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                            )

                            Text(
                                text = "Sign in to continue",
                                style = textStyle,
                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                            )

                            Text(
                                text = "Username",
                                style = textStyle,
                                modifier = Modifier.padding(start = 20.dp, top = 50.dp)
                            )

                            TextField(
                                value = username.value,
                                onValueChange = {
                                    username.value = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.White)
                                    .padding(start = 20.dp, end = 20.dp),
                                placeholder = {
                                    Text(text = "Enter user name")
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                ),
                                keyboardOptions = KeyboardOptions(
                                    capitalization = KeyboardCapitalization.Unspecified,
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        passwordFocusRequester.requestFocus()
                                    }
                                )
                            )

                            Text(
                                text = "Passwrod",
                                style = textStyle,
                                modifier = Modifier.padding(start = 20.dp, top = 25.dp)
                            )

                            var passwordError by remember { mutableStateOf(false) }
                            TextField(
                                value = password.value,
                                onValueChange = {
                                    password.value = it
                                    passwordError = false
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.White)
                                    .padding(start = 20.dp, end = 20.dp)
                                    .focusRequester(passwordFocusRequester),
                                placeholder = {
                                    Text(text = "Enter Password")
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    errorTextColor = Color.Red,
                                    errorContainerColor = Color.Red,
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Done
                                ),
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        Toast.makeText(
                                            this@LoginScreenActivity,
                                            "Login Successfully!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                )
                            )
                            if (passwordError) {
                                Text(
                                    text = "Please enter password",
                                    color = Color.Red,
                                    fontSize = 12.sp
                                )
                            }
                            TextButton(
                                onClick = {
                                    Toast.makeText(
                                        this@LoginScreenActivity,
                                        "Clicked Forgot password",
                                        Toast.LENGTH_LONG
                                    ).show()
                                },
                                modifier = Modifier
                                    .padding(end = 10.dp, top = 5.dp)
                                    .align(alignment = Alignment.End)
                            ) {
                                Text(
                                    text = "Forgot your password",
                                    style = textStyle
                                )
                            }

                            Button(
                                onClick = {
                                    if (username.value.isEmpty()) {
                                        Toast.makeText(
                                            this@LoginScreenActivity,
                                            "please enter username",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    } else if (password.value.isEmpty()) {
                                        passwordError = true
                                    } else {
                                        Toast.makeText(
                                            this@LoginScreenActivity,
                                            "Login Successfully!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                },
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 40.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "SIGN IN")
                            }

                            Row(
                                modifier = Modifier.padding(top = 80.dp).align(alignment = Alignment.CenterHorizontally)
                            ) {
                                Button(
                                    onClick = {
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    )
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.ellipse_first),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(
                                            text = "f",
                                            style = TextStyle(
                                                fontSize = 35.sp,
                                                fontWeight = FontWeight.Bold
                                            ),
                                            modifier = Modifier.align(alignment = Alignment.Center)
                                        )
                                    }
                                }
                                Button(
                                    onClick = {
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    )
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.ellipse_third),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.twitter),
                                            contentDescription = "",
                                            modifier = Modifier.align(alignment = Alignment.Center)
                                        )
                                    }
                                }
                                Button(
                                    onClick = {
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    )
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.ellipse_second),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(
                                            text = "G",
                                            style = TextStyle(
                                                fontSize = 35.sp,
                                                fontWeight = FontWeight.Bold
                                            ),
                                            modifier = Modifier.align(alignment = Alignment.Center)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

