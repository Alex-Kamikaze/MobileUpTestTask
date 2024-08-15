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
            val gson = Gson()
            val imageType = object : TypeToken<Map<String, Map<String, String>>>() {}.type
            val imageVariants: Map<String, Map<String, String>> = gson.fromJson(response["image"].toString(), imageType)
            val descriptionType = object: TypeToken<Map<String, Map<String, String>>>() {}.type
            val descriptionTag: Map<String, Map<String, String>> = gson.fromJson(response["description"].toString(), descriptionType)
            val categoriesType = object : TypeToken<Map<String, List<String>>>() {}.type
            val categoriesList: Map<String, List<String>> = gson.fromJson(response["categories"].toString(), categoriesType)
            Result.success(
                CoinDetailsModel(
                    coinName = response["name"].toString(),
                    coinImageUrl = imageVariants["large"].toString(),
                    coinCategories = (categoriesList["categories"]?.joinToString(", ") ?: emptyList<String>()).toString(),
                    coinDescription = descriptionTag["en"].toString()
                )
            )
        }
        catch(e: Exception) {
            Result.failure(e)
        }
    }
}