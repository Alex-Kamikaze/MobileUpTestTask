package com.example.testtask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.toRoute
import com.example.testtask.ui.components.MainScreen
import com.example.testtask.ui.routes.CoinDetailsScreenRoute
import com.example.testtask.ui.routes.MainScreenRoute
import com.example.testtask.ui.theme.TestTaskTheme
import com.example.testtask.ui.viewmodels.MainScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTaskTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    val mainScreenViewModel: MainScreenViewModel by viewModels()
                    NavHost(navController = navController, startDestination = MainScreenRoute) {
                        composable<MainScreenRoute> {
                            mainScreenViewModel.loadCoins()
                            MainScreen(viewModel = mainScreenViewModel)
                        }
                        composable<CoinDetailsScreenRoute> { backStackEntry ->
                            val coinId = backStackEntry.toRoute<CoinDetailsScreenRoute>().coinName

                        }
                    }
                }
            }
        }
    }
}