package com.example.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layouts.ui.theme.LayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsTheme {
                //MyLayouts(name = "Android")
                MyAlignments()
            }
        }
    }
}

@Composable
fun MyAlignments() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
        //contentAlignment = Alignment.Center) for Box layout
    {
        Text(text = "Hello",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.background(Color.Red).padding(start = 20.dp, end = 30.dp))

        Spacer(modifier = Modifier.size(20.dp))

        Text(text = "Android",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.background(Color.Red).width(100.dp))

        Spacer(modifier = Modifier.size(20.dp))

        Text(text = "Kotlin",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.background(Color.Red).width(100.dp))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Composable
fun MyLayouts(name: String) {
    Column {
        Box(modifier = Modifier.background(Color.Red).height(200.dp).width(300.dp)) {
            Row {
                Box(modifier = Modifier.size(50.dp).background((Color.Blue)))
                Column {
                    Text(text = "Hello ")
                    Text(text = "$name!")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutsTheme {
        //Greeting("Android")
        //MyLayouts("Android")
        MyAlignments()
    }
}