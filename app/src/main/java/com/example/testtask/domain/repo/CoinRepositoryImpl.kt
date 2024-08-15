package com.example.testtask.domain.repo

import com.example.testtask.data.remote.GeckoApi
import com.example.testtask.data.repo.CoinRepository
import com.example.testtask.domain.models.CoinDetailsModel
import com.example.testtask.domain.models.CoinListItemModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: GeckoApi): CoinRepository{
    override suspend fun getCoinList(currency: String): Result<List<CoinListItemModel>> {
        return try {
            val response = api.getCoinList(currency)
            Result.success(response.map { coinInfo ->
                CoinListItemModel(
                   coinId = coinInfo["id"].toString(),
                   coinName = coinInfo["name"].toString(),
                   coinImageUrl = coinInfo["image"].toString(),
                   coinCurrentPrice = coinInfo["current_price"].toString().toDouble(),
                   coinShortName = coinInfo["symbol"].toString(),
                   currencyForPrice = if(currency == "RUB") "₽" else "$",
                   currentTendency = coinInfo["price_change_24h"].toString().toDouble(),
                   percentTendency = coinInfo["price_change_percentage_24h"].toString().toDouble()
                )
            })
        }
        catch(e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getCoinInfo(coinId: String): Result<CoinDetailsModel> {
        return try {
            val response = api.getCoinInfo(coinId)
            Result.success(
                CoinDetailsModel(
                    coinDescription = response.description.en,
                    coinImageUrl = response.image.large,
                    coinName = response.name,
                    coinCategories = response.categories.joinToString(", ")
                )
            )
        }
        catch(e: Exception) {
            Result.failure(e)
        }
    }
}