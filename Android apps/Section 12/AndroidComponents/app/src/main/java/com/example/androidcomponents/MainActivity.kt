package com.example.androidcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomponents.ui.theme.AndroidComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Components()
                }
            }
        }
    }
}

@Composable
fun Components() {
    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Do your magic")
    }

    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }

    val myText = remember {
        mutableStateOf("Hello World")
    }

    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val buttonsStatus = remember {
        mutableStateOf(true)
    }

    val valueOnTextfield = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("Result")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (buttonsStatus.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {
                if (buttonsStatus.value) {
                    myButtonBackgroundColor.value = Color.Black
                    myButtonText.value = "Compose is fun"
                    myButtonTextColor.value = Color.Red
                    myText.value = "Hello Compose"
                    myTextColor.value = Color.White

                    buttonsStatus.value = false
                } else {
                    myButtonBackgroundColor.value = Color.Black
                    myButtonText.value = "Do your magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World"
                    myTextColor.value = Color.Black

                    buttonsStatus.value = true
                }

                userInput.value = valueOnTextfield.value
                valueOnTextfield.value = ""
            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        TextField(
            value = valueOnTextfield.value,
            onValueChange = {
                valueOnTextfield.value = it
            },
            label = { Text(text = "Enter your name", color = Color.White) },
            modifier = Modifier.width(300.dp),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 4,
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            //visualTransformation = PasswordVisualTransformation()
            )

        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = userInput.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidComponentsTheme {
        Components()
    }
}