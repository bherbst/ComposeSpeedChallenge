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
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeButtonElevation
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red
import com.example.androiddevchallenge.ui.theme.white
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    BottomSheetScaffold(
        modifier = Modifier.navigationBarsPadding(),
        sheetContent = { PositionsSheet() },
        content = { HomeContent() },
        sheetShape = RoundedCornerShape(0.dp),
        sheetPeekHeight = 64.dp
    )
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 64.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "ACCOUNT",
                style = MaterialTheme.typography.button,
                color = white
            )
            Text(
                text = "WATCHLIST",
                style = MaterialTheme.typography.button,
                color = white.copy(alpha = .8f)
            )
            Text(
                text = "PROFILE",
                style = MaterialTheme.typography.button,
                color = white.copy(alpha = .8f)
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 32.dp, bottom = 8.dp),
            text = "Balance",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 48.dp, bottom = 24.dp),
            text = "$73,589.01",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 16.dp, bottom = 32.dp),
            text = "+412.35 today",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
            color = green
        )

        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            onClick = { /* TODO */ },
            elevation = WeTradeButtonElevation(),
            shape = MaterialTheme.shapes.large
        ) {
            Text(text = "TRANSACT")
        }

        Spacer(Modifier.height(16.dp))

        HomeButtons()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_illos),
                contentDescription = "balance graph"
            )
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun HomeButtons() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(start = 16.dp)
            .height(40.dp)
            .fillMaxWidth()
    ) {
        HomeButton(
            text = "Week",
            iconVector = Icons.Default.ExpandMore
        )
        Spacer(Modifier.width(8.dp))
        HomeButton("ETFs")
        Spacer(Modifier.width(8.dp))
        HomeButton("Stocks")
        Spacer(Modifier.width(8.dp))
        HomeButton("Funds")
        Spacer(Modifier.width(8.dp))
        HomeButton("More")
    }
}

@Composable
private fun HomeButton(
    text: String,
    iconVector: ImageVector? = null
) {
    OutlinedButton(
        modifier = Modifier.fillMaxHeight(),
        onClick = { /* TODO */ },
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(ButtonDefaults.OutlinedBorderSize, white)
    ) {
        Text(
            text = text,
            color = white,
            style = MaterialTheme.typography.body1
        )

        iconVector?.let {
            Icon(
                imageVector = iconVector,
                contentDescription = null,
                tint = white
            )
        }
    }
}

@Composable
fun PositionsSheet() {
    Surface {
        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 40.dp, bottom = 24.dp),
                text = "Positions",
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )

            LazyColumn {
                items(stocks) { stock ->
                    Divider()
                    StockRow(stock)
                }
            }
        }
    }
}

@Composable
fun StockRow(stock: Stock) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                modifier = Modifier.paddingFromBaseline(top = 24.dp),
                text = stock.price,
                style = MaterialTheme.typography.body1
            )
            Text(
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                text = "${stock.delta}%",
                color = if (stock.delta > 0) green else red,
                style = MaterialTheme.typography.body1
            )
        }

        Spacer(Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                modifier = Modifier.paddingFromBaseline(top = 24.dp),
                text = stock.symbol,
                style = MaterialTheme.typography.h3
            )
            Text(
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                text = stock.name,
                style = MaterialTheme.typography.body1
            )
        }

        Image(
            painter = painterResource(id = stock.graphResource),
            contentDescription = "${stock.name} price history graph"
        )
    }
}

@Preview(
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun HomeScreenPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview(
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun HomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview(
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun PositionsPreview() {
    MyTheme {
        PositionsSheet()
    }
}

@Preview(
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun PositionsDarkPreview() {
    MyTheme(darkTheme = true) {
        PositionsSheet()
    }
}
