package com.loyltworks.myapplication

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme

class SignupActivity : ComponentActivity() {

    val username = mutableStateOf("")
    val email = mutableStateOf("")
    val passwrod = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.darkBlack)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = Modifier.height(50.dp))
                        Row {
                            Box(contentAlignment = Alignment.Center) {
                                Image(
                                    painter = painterResource(R.drawable.back_bg),
                                    contentDescription = "",
                                    modifier = Modifier.size(40.dp)
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = "",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.size(21.dp))
                            Text(
                                text = "Sign up",
                                fontWeight = FontWeight.Bold,
                                style = TextStyle(
                                    color = colorResource(R.color.white),
                                    fontSize = 20.sp
                                ),
                                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                            )
                        }
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(
                            text = "Create an account for free to get started!",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 15.sp
                            ),
                            fontSize = 15.sp
                        )
                        //TextFields
                        username()
                        email()
                        password()

                        //Button
                        val buttonPressed = remember { mutableStateOf(false) }
                        Spacer(modifier = Modifier.height(50.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                                .height(60.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            colorResource(R.color.liteBlue),
                                            colorResource(R.color.darkBlue)
                                        )
                                    )
                                )
                                .border(
                                    width = 0.5.dp,
                                    color = colorResource(R.color.lightBlack),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            buttonPressed.value = true
                                        },
                                        onTap = {
                                            buttonPressed.value = false
                                        }
                                    )
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "SIGN UP",
                                color = colorResource(R.color.white),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .padding(start = 15.dp)
                            )
                            Text(
                                "OR",
                                color = colorResource(R.color.white),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(all = 10.dp)
                            )

                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .padding(end = 10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .weight(1f)
                                    .background(color = colorResource(R.color.lightBlack))
                                    .border(
                                        width = 1.dp,
                                        color = Color.Gray,
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    "G",
                                    color = colorResource(R.color.white),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .weight(1f)
                                    .background(color = colorResource(R.color.lightBlack))
                                    .border(
                                        width = 1.dp,
                                        color = Color.Gray,
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.twitter),
                                    contentDescription = "",
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Already have an account?",
                                fontSize = 15.sp,
                                color = colorResource(R.color.white)
                            )

                            Text(
                                text = "Log in",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = colorResource(R.color.white)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun username() {
        Text(
            text = "Name",
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(start = 10.dp, top = 24.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .padding(start = 10.dp)
                .background(
                    color = colorResource(R.color.lightBlack),
                )
                .border(
                    width = 2.dp,
                    //color = colorResource(R.color.mediumBlack),
                    shape = RoundedCornerShape(12.dp),
                    brush = Brush.verticalGradient(
                        if (username.value.length > 3) listOf(
                            colorResource(R.color.liteBlue),
                            colorResource(R.color.darkBlue)
                        ) else listOf(
                            colorResource(R.color.mediumBlack),
                            colorResource(R.color.mediumBlack)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    if (username.value.isEmpty()) {
                        Text("Enter User Name", color = Color.Gray)
                    }
                    BasicTextField(
                        value = username.value, onValueChange = {
                            username.value = it
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.white),
                        ),
                        cursorBrush = SolidColor(Color.White),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {

                            }
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(
                            if (username.value.length > 3) {
                                Color(R.color.mediumBlack)
                            } else {
                                Color.Transparent
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (username.value.length > 3) {
                        Icon(
                            painter = painterResource(R.drawable.qr),
                            contentDescription = "",
                            tint = colorResource(R.color.white),
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun email() {
        Text(
            text = "Email",
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(start = 10.dp, top = 24.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .padding(start = 10.dp)
                .background(
                    color = colorResource(R.color.lightBlack),
                )
                .border(
                    width = 2.dp,
                    //color = colorResource(R.color.mediumBlack),
                    shape = RoundedCornerShape(12.dp),
                    brush = Brush.verticalGradient(
                        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) listOf(
                            colorResource(R.color.liteBlue),
                            colorResource(R.color.darkBlue)
                        ) else listOf(
                            colorResource(R.color.mediumBlack),
                            colorResource(R.color.mediumBlack)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    if (email.value.isEmpty()) {
                        Text("Enter Email", color = Color.Gray)
                    }
                    BasicTextField(
                        value = email.value, onValueChange = {
                            email.value = it
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.white),
                        ),
                        cursorBrush = SolidColor(Color.White),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {

                            }
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(
                            if (email.value.length > 3) {
                                Color(R.color.mediumBlack)
                            } else {
                                Color.Transparent
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (email.value.length > 3) {
                        Icon(
                            painter = painterResource(R.drawable.qr),
                            contentDescription = "",
                            tint = colorResource(R.color.white),
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun password() {
        Text(
            text = "Password",
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(start = 10.dp, top = 24.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .padding(start = 10.dp)
                .background(
                    color = colorResource(R.color.lightBlack),
                )
                .border(
                    width = 2.dp,
                    //color = colorResource(R.color.mediumBlack),
                    shape = RoundedCornerShape(12.dp),
                    brush = Brush.verticalGradient(
                        if (passwrod.value.length > 3) listOf(
                            colorResource(R.color.liteBlue),
                            colorResource(R.color.darkBlue)
                        ) else listOf(
                            colorResource(R.color.mediumBlack),
                            colorResource(R.color.mediumBlack)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    if (passwrod.value.isEmpty()) {
                        Text("Enter Password", color = Color.Gray)
                    }
                    BasicTextField(
                        value = passwrod.value, onValueChange = {
                            passwrod.value = it
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.white),
                        ),
                        cursorBrush = SolidColor(Color.White),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Go
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardActions = KeyboardActions(
                            onGo = {

                            }
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(
                            if (passwrod.value.length > 3) {
                                Color(R.color.mediumBlack)
                            } else {
                                Color.Transparent
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (passwrod.value.length > 3) {
                        Icon(
                            painter = painterResource(R.drawable.qr),
                            contentDescription = "",
                            tint = colorResource(R.color.white),
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
        }
    }
}
