package com.example.testtask.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtask.R

@Preview
@Composable
fun ErrorScreen(onRestartButtonClick: () -> Unit = {}) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
        .padding(10.dp)
        .height(240.dp)) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.bitcoin_img), contentDescription = null, tint = Color.Unspecified)
        Text("Произошла какая-то ошибка :(", fontSize = 16.sp)
        Text("Попробуем снова?", fontSize = 16.sp)
        Button(onClick = { onRestartButtonClick() }, modifier = Modifier
            .padding(top = 20.dp)
            .width(175.dp)
            .height(36.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.chosenCurrencyButtonColor),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
           Text("Попробовать снова", fontSize = 16.sp, textAlign = TextAlign.Center)
        }
    }
}