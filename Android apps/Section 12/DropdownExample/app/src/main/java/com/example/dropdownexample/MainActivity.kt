package com.example.dropdownexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dropdownexample.ui.theme.DropdownExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DropdownExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropdownExample()
                }
            }
        }
    }
}

@Composable
fun DropdownExample() {
    /*val selectedItem = remember {
        mutableStateOf("Germany")
    }*/

    val dropdownStatus = remember {
        mutableStateOf(false)
    }

/*
    val countryList = listOf("Germany", "England", "Italy", "Belgium", "Finland", "Turkey", "Bulgaria", "Greece", "Netherlands", "Russia", "Brazil", "Argentina",
        "Germany", "England", "Italy", "Belgium", "Finland", "Turkey", "Bulgaria", "Greece", "Netherlands", "Russia", "Brazil", "Argentina")
*/
    val countryList = stringArrayResource(R.array.countryList)

    val itemPosition = remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    dropdownStatus.value = true
                }
            ) {
                Text(
                    text = countryList[itemPosition.value],
                    modifier = Modifier.clickable {
                        dropdownStatus.value = true
                    })
                Image(painter = painterResource(R.drawable.drop_down_icon), contentDescription = "")
            }

            DropdownMenu(
                expanded = dropdownStatus.value,
                onDismissRequest = {
                    dropdownStatus.value = false
                }
            ) {

                countryList.forEachIndexed { index, country ->
                    DropdownMenuItem(
                        onClick = {
                            dropdownStatus.value = false
                            itemPosition.value = index
                        },
                        text = { Text(text = country) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DropdownExampleTheme {
        DropdownExample()
    }
}