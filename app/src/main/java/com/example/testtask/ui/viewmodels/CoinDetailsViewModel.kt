package com.example.testtask.ui.viewmodels

import android.provider.Contacts.Intents.UI
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.domain.repo.CoinRepositoryImpl
import com.example.testtask.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(private val repo: CoinRepositoryImpl): ViewModel() {
    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadCoinDetails(coinId: String) {
        _uiState.value = UIState.Loading
        viewModelScope.launch {
            println(coinId)
            val result = repo.getCoinInfo(coinId)
            if(result.isSuccess) {
                _uiState.value = UIState.Success(result.getOrNull()!!)
            }
            else {
                Log.e("INTERNET_ERROR", result.exceptionOrNull()?.message!!)
                _uiState.value = UIState.Error("Произошла ошибка при загрузке данных")
            }
        }
    }

}