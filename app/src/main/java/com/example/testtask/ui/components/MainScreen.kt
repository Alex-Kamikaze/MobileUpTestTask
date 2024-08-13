package com.example.testtask.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testtask.R
import com.example.testtask.domain.models.CoinListItemModel


@Preview(showBackground = true)
@Composable
fun MainScreen(modifier: Modifier = Modifier, coins: List<String> = listOf()) {
    val currencies = listOf("USD", "RUB")
    var chosenCurrency by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .shadow(1.dp)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    "Список криптовалют",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    currencies.forEachIndexed { index, currency ->
                        Button(
                            onClick = { chosenCurrency = index },
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .width(90.dp)
                                .height(32.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = if(index == chosenCurrency) colorResource(
                                id = R.color.chosenCurrencyButtonColor
                            ).copy(alpha = 0.3f) else Color.Gray.copy(alpha = 0.3f), contentColor = if(index == chosenCurrency) colorResource(
                                id = R.color.chosenCurrencyTextColor
                            ) else Color.White)
                        ) {
                            Text(currency)
                        }
                    }
                }
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(2) {
                CoinListItem()
            }
        }
    }
}


@Composable
fun CoinListItem(coinInfo: CoinListItemModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 12.dp)) {
        AsyncImage(model = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400", contentDescription = null, modifier = Modifier.size(40.dp))
        Column {
            Text(coinInfo.coinName, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(coinInfo.coinShortName, fontSize = 14.sp, modifier = Modifier.padding(top = 2.dp))
        }
    }
}