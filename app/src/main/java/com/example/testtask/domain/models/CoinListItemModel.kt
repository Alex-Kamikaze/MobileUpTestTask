package com.example.testtask.domain.models

data class CoinListItemModel(
    val coinId: String,
    val coinName: String,
    val coinImageUrl: String,
    val coinCurrentPrice: Double,
    val currencyForPrice: String,
    // Проценты роста или падения стоимости монеты
    val currentTendency: Double,
    val coinShortName: String,
    val percentTendency: Double
)
