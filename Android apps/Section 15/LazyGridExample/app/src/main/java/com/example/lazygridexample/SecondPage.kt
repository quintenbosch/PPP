package com.example.lazygridexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(navController: NavController, id : Int) {
    val countryList = retrieveCountries()
    val selectedCountry = countryList[id - 1]

    Scaffold(
        topBar =  {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Arrow back")
                    }
                },
                title = {
                    Text(
                        text = "Details",
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = selectedCountry.countryImage),
                    contentDescription = selectedCountry.countryName,
                    modifier = Modifier.size(350.dp, 250.dp).border(2.dp, Color.Black),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                Spacer(
                    modifier = Modifier.height(50.dp)
                )
                Text(text = selectedCountry.countryName, color = Color.Black, fontSize = 24.sp)
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(text = selectedCountry.countryDetail, color = Color.Black, fontSize = 20.sp)
            }
        }
    )
}