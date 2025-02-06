package com.example.lazycolumnexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.example.lazycolumnexample.ui.theme.LazyColumnExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnExampleTheme {
                Surface {
                    FirstPage()
                }
            }
        }
    }
}

@Composable
fun FirstPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Countries", fontSize = 20.sp)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    titleContentColor = Color.White
                ),
            )
        },
        content = {
            
        }
    )
}