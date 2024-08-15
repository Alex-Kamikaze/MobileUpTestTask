package com.example.testtask.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testtask.domain.models.CoinDetailsModel
import com.example.testtask.ui.viewmodels.CoinDetailsViewModel
import com.example.testtask.utils.UIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDetailsScreen(coinId: String, viewModel: CoinDetailsViewModel, onNavigateBack: () -> Unit) {
    var offset by remember { mutableFloatStateOf(0f) }
    val loadingState = viewModel.uiState.collectAsState()
    when(loadingState.value) {
        is UIState.Error -> {
            ErrorScreen {
                viewModel.loadCoinDetails(coinId = coinId)
            }
        }
        UIState.Loading -> LoadingScreen()
        is UIState.Success<*> -> {
            val coinDetails = (loadingState.value as UIState.Success<CoinDetailsModel>).data
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = { TopAppBar(title = { Text(coinDetails.coinName) }, navigationIcon = { IconButton(
                onClick = { onNavigateBack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null) }
            })}) { innerPadding ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(model = coinDetails.coinImageUrl, contentDescription = null, modifier = Modifier.size(90.dp))
                    Spacer(modifier = Modifier.height(25.dp))
                    Text("Описание", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Left, fontWeight = FontWeight.Medium)
                    Text(text = coinDetails.coinDescription, modifier = Modifier.padding(top = 5.dp))
                    Spacer(modifier = Modifier.height(25.dp))
                    Text("Категории", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Left, fontWeight = FontWeight.Medium)
                    Text(text = coinDetails.coinCategories)
                }
            }
        }
    }
}