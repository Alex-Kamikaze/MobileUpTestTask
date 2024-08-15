package com.example.testtask.data.remote

import com.example.testtask.data.models.CoinDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GeckoApi {
    @GET("coins/markets")
    @Headers("x-cg-demo-api-key: $API_KEY")
    suspend fun getCoinList(@Query("vs_currency") currency: String): List<Map<String, Any>>

    @GET("coins/{id}")
    @Headers("x-cg-demo-api-key: $API_KEY")
    suspend fun getCoinInfo(
        @Path("id") coinId: String,
        @Query("localization") localization: Boolean = false,
        @Query("tickers") tickers: Boolean = false,
        @Query("market_data") market_data: Boolean = false,
        @Query("community_data") community_data: Boolean = false,
        @Query("developer_data") developer_data: Boolean = false,
        @Query("sparkline") sparkline: Boolean = false
    ): CoinDetailsDTO

    companion object {
        const val BASE_URL = "https://api.coingecko.com/api/v3/"
        const val API_KEY = "CG-VZbw2wVAy9X3X4neNqsEYQkU"
    }

}