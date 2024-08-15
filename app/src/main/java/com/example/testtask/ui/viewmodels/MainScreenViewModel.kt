package com.example.testtask.ui.viewmodels

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
class MainScreenViewModel @Inject constructor(private val repo: CoinRepositoryImpl): ViewModel() {
    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _testState = MutableStateFlow<Boolean>(true)
    val testState = _testState.asStateFlow()

    // По умолчанию грузим список монет с ценами в долларах
    fun loadCoins(currency: String = "USD") {
        _uiState.value = UIState.Loading
        println(uiState)
        viewModelScope.launch {
            val result = repo.getCoinList(currency)
            if(result.isSuccess) {
                _uiState.value = UIState.Success(result.getOrDefault(listOf()))
                println(uiState)
            }
            else {
                Log.e("INTERNET_ERROR", result.exceptionOrNull()?.message!!)
                _uiState.value = UIState.Error("Произошла ошибка при загрузке данных")
            }
        }
    }

}