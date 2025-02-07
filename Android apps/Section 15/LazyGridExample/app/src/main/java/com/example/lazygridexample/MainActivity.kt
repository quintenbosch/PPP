package com.example.lazygridexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lazygridexample.ui.theme.LazyGridExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyGridExampleTheme {
                Surface {
                    MyNavigation()
                }
            }
        }
    }
}

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FirstPage") {
        composable("FirstPage") {
            FirstPage(navController = navController)
        }
        composable("SecondPage/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val countryId = it.arguments?.getInt("id")
            countryId?.let { id ->
                SecondPage(navController = navController, id = id)
            }
        }
    }
}