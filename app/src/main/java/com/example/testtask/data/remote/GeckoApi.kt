package com.example.testtask.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GeckoApi {
    @GET("/coins/markets")
    @Headers("x-cg-demo-api-key: $API_KEY")
    suspend fun getCoinList(@Query("vs_currency") currency: String): List<Map<String, Any>>

    @GET("/coins/id")
    @Headers("x-cg-demo-api-key: $API_KEY")
    suspend fun getCoinInfo(@Query("id") coinId: String): Map<String, Any>

    companion object {
        const val BASE_URL = "https://api.coingecko.com/api/v3"
        const val API_KEY = "CG-VZbw2wVAy9X3X4neNqsEYQkU"
    }

}