package com.example.testtask.utils

import com.example.testtask.domain.models.CoinListItemModel

sealed class UIState {
    data object Loading: UIState()
    data class Success(val coins: List<CoinListItemModel>): UIState()
    data class Error(val message: String): UIState()
}