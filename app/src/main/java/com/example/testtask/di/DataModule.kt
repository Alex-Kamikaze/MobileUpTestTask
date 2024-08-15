package com.example.testtask.di

import com.example.testtask.data.remote.GeckoApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    fun provideCoinApi(): GeckoApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GeckoApi.BASE_URL)
            .build()
            .create(GeckoApi::class.java)
    }
}