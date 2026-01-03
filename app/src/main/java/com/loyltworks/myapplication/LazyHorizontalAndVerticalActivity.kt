package com.loyltworks.myapplication

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.loyltworks.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.*

class LazyHorizontalAndVerticalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp)
                        .background(Color.Black)
                ) {

                    Box {
                        Column {
                            val composition by rememberLottieComposition(
                                LottieCompositionSpec.RawRes(R.raw.load)
                            )

                            LottieAnimation(
                                composition = composition,
                                modifier = Modifier.size(100.dp),
                                iterations = LottieConstants.IterateForever
                            )
                            layzyColumn()
                            //horizontalLayzy()
                            //verticalLayzy()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun layzyColumn() {
    val data = MutableList(100) {
        it.toString()
    }.toList()


    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .background(color = colorResource(R.color.black))
            ) {
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.black),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnScope.verticalLayzy() {
    val data = MutableList(100) {
        it.toString()
    }.toList()


    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .background(color = colorResource(R.color.black))
            ) {
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.black),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}


@Composable
fun horizontalLayzy() {
    val data = MutableList(100) {
        it.toString()
    }.toList()


    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp)
                    .background(color = colorResource(R.color.black))
            ) {
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.black),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}