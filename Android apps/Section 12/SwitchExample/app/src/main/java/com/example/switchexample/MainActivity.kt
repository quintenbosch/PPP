package com.example.switchexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.switchexample.ui.theme.SwitchExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwitchExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SwitchExample()
                }
            }
        }
    }
}

@Composable
fun SwitchExample() {
    val switchState = remember {
        mutableStateOf(false)
    }

    val myText = remember {
        mutableStateOf("The image is visible")
    }

    val myAlphaValue = remember {
        mutableStateOf(1F)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(50.dp))

        Switch(
            checked = switchState.value,
            onCheckedChange = {
                switchState.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color.Red,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Blue
            )
        )

        Spacer(modifier = Modifier.size(30.dp))

        if (!switchState.value) {
            myText.value = "The image is visible"
            myAlphaValue.value = 1F
        } else {
            //Spacer(modifier = Modifier.size(300.dp))
            myText.value = "The image is invisible"
            myAlphaValue.value = 0F
        }

        Image(
            painter = painterResource(id = R.drawable.boat),
            contentDescription = "",
            modifier = Modifier.size(300.dp).alpha(myAlphaValue.value),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = myText.value,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue)
                .width(300.dp)
                .padding(top = 10.dp, bottom = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SwitchExampleTheme {
        SwitchExample()
    }
}