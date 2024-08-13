package com.example.testtask.ui.routes

import kotlinx.serialization.Serializable

@Serializable
data object MainScreenRoute

@Serializable
data class CoinDetailsScreenRoute(val coinName: String)