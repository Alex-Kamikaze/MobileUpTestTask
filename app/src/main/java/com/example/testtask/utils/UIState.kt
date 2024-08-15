package com.example.testtask.utils

import com.example.testtask.domain.models.CoinListItemModel

sealed class UIState {
    data object Loading : UIState()
    data class Success(val coins: List<CoinListItemModel>) : UIState()
    data class Error(val message: String) : UIState()

    fun isSuccess(): Boolean {
        return this is Success
    }

    fun Success.getData(): List<CoinListItemModel> {
        return this.coins
    }
}