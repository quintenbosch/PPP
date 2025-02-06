package com.example.dialogmessageexample

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dialogmessageexample.ui.theme.DialogMessageExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogMessageExampleTheme {
                Surface() {
                    DialogMessageExample()
                }
            }
        }
    }
}

@Composable
fun DialogMessageExample() {
    val dialogStatus = remember {
        mutableStateOf(false)
    }

    val textColor = remember {
        mutableStateOf(Color.White)
    }

    val myContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                dialogStatus.value = true
            }
        ) { Text(text = "Show Dialog Message", color = textColor.value) }

        if (dialogStatus.value) {
            AlertDialog(
                onDismissRequest = {
                    dialogStatus.value = true
                },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(R.drawable.warning), contentDescription = "")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Dialog Message", color = Color.Red, fontSize = 20.sp)
                    }
                },
                text = {
                    Text(
                        text = "Do you wanna change the text color of the button?",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                },
                containerColor = Color.Blue,
                shape = RoundedCornerShape(10.dp),
                confirmButton = {
                    Button(
                        onClick = {
                            dialogStatus.value = false
                            textColor.value = Color.Red
                            Toast.makeText(myContext, "Confirm button is clicked", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(text = "YES", color = Color.Green, fontSize = 18.sp)
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            dialogStatus.value = false
                            Toast.makeText(myContext, "Dismiss button is clicked", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(text = "NO", color = Color.Red, fontSize = 18.sp)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogMessageExampleTheme {
        DialogMessageExample()
    }
}