/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeButtonElevation
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun WelcomeScreen(
    navigateToLogin: () -> Unit
) {
    Box(
        modifier = Modifier.navigationBarsPadding()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.welcome_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier.weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "WeTrade"
                )
            }

            Row(
                modifier = Modifier.padding(
                    bottom = 32.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                    .height(48.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxSize()
                        .weight(1f),
                    onClick = { /*TODO*/ },
                    elevation = WeTradeButtonElevation(),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "GET STARTED")
                }

                Spacer(Modifier.width(8.dp))

                OutlinedButton(
                    modifier = Modifier.fillMaxSize()
                        .weight(1f),
                    onClick = { navigateToLogin() },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent,

                    ),
                    shape = MaterialTheme.shapes.large,
                    border = BorderStroke(ButtonDefaults.OutlinedBorderSize, MaterialTheme.colors.primary)
                ) {
                    Text(text = "LOG IN")
                }
            }
        }
    }
}

@Preview(
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun WelcomeScreenPreview() {
    MyTheme {
        WelcomeScreen(navigateToLogin = { })
    }
}

@Preview(
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun WelcomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(navigateToLogin = { })
    }
}
