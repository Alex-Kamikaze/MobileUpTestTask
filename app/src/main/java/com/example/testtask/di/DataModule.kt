package com.example.testtask.di

import com.example.testtask.data.remote.GeckoApi
import com.example.testtask.domain.repo.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideCoinApi(): GeckoApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GeckoApi.BASE_URL)
            .build()
            .create(GeckoApi::class.java)
    }

    @Provides
    fun provideCoinRepository(coinApi: GeckoApi): CoinRepositoryImpl {
        return CoinRepositoryImpl(api = coinApi)
    }
}