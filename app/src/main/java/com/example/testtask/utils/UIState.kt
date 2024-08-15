package com.example.testtask.utils

import com.example.testtask.domain.models.CoinListItemModel

sealed class UIState {
    data object Loading : UIState()
    data class Success<T>(val coins: T) : UIState()
    data class Error(val message: String) : UIState()
}