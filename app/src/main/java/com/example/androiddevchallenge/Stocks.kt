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

import androidx.annotation.DrawableRes

data class Stock(
    val symbol: String,
    val name: String,
    val price: String,
    val delta: Double,
    @DrawableRes val graphResource: Int
)

val stocks: List<Stock> = listOf(
    Stock(
        symbol = "ALK",
        name = "Alaska Air Group, Inc",
        price = "$7,918",
        delta = -0.54,
        graphResource = R.drawable.home_alk
    ),
    Stock(
        symbol = "BA",
        name = "Boeing Co.",
        price = "$1,293",
        delta = 4.18,
        graphResource = R.drawable.home_ba
    ),
    Stock(
        symbol = "DAL",
        name = "Delta Airlines Inc.",
        price = "$893.50",
        delta = -0.54,
        graphResource = R.drawable.home_dal
    ),
    Stock(
        symbol = "EXPE",
        name = "Expedia Group Inc.",
        price = "$12,301",
        delta = 2.51,
        graphResource = R.drawable.home_exp
    ),
    Stock(
        symbol = "EADSY",
        name = "Airbus SE",
        price = "$12,301",
        delta = 1.38,
        graphResource = R.drawable.home_eadsy
    ),
    Stock(
        symbol = "JBLU",
        name = "Jetblue Airways Corp.",
        price = "$8,521",
        delta = 1.56,
        graphResource = R.drawable.home_jblu
    ),
    Stock(
        symbol = "MAR",
        name = "Marriott International Inc.",
        price = "$521",
        delta = 2.75,
        graphResource = R.drawable.home_mar
    ),
    Stock(
        symbol = "CCL",
        name = "Carnival Corp",
        price = "$5,481",
        delta = -0.14,
        graphResource = R.drawable.home_ccl
    ),
    Stock(
        symbol = "RCL",
        name = "Royal Caribbean Cruises",
        price = "$9,184",
        delta = 1.69,
        graphResource = R.drawable.home_rcl
    ),
    Stock(
        symbol = "TRVL",
        name = "Travelocity Inc.",
        price = "$654",
        delta = 3.23,
        graphResource = R.drawable.home_trvl
    ),
)
