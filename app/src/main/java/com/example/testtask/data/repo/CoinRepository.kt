package com.example.testtask.data.repo

import com.example.testtask.domain.models.CoinDetailsModel
import com.example.testtask.domain.models.CoinListItemModel

interface CoinRepository {
    suspend fun getCoinList(currency: String): Result<List<CoinListItemModel>>
    suspend fun getCoinInfo(coinId: String): Result<CoinDetailsModel>
}