package com.example.androiddevchallenge

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun WelcomeScreen(
    navigateToLogin: () -> Unit
) {
    Box {
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
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "GET STARTED")
                }

                Spacer(Modifier.width(8.dp))

                OutlinedButton(
                    modifier = Modifier.fillMaxSize()
                        .weight(1f),
                    onClick = { navigateToLogin()},
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