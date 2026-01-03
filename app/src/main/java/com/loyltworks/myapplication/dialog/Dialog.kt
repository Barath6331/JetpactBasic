package com.loyltworks.myapplication.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun Dialog(viewModel: DialogViewModel) {
    Box(contentAlignment = Alignment.Center) {
        Button(onClick = { viewModel.showDialog() }) {
            Text("Show Dialog")
        }
    }
    if (viewModel.dialoger.enabled.value) {
        Dialog(
            onDismissRequest = {
                viewModel.dialoger.onDone("dismiss")
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                ) {
                    Text("Heading")
                    Divider()
                    Text("Message?")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = {
                            viewModel.dialoger.onDone("Positive")
                        }) {
                            Text("Ok")
                        }

                        TextButton(onClick = {
                            viewModel.dialoger.onDone("Negative")
                        }) {
                            Text("Cancel")
                        }
                    }
                }
            }
        }
    }
}