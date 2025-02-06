package com.example.lazycolumnexample

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveCountries() : SnapshotStateList<CountryModel> {
    val countryList = remember {
        mutableStateListOf(
            CountryModel(1, "Argentina", "This is the Argentina Flag", R.drawable.argentina),
            CountryModel(2, "Brazil", "This is the Brazil Flag", R.drawable.brazil),
            CountryModel(3, "Bulgaria", "This is the Bulgaria Flag", R.drawable.bulgaria),
            CountryModel(4, "France", "This is the France Flag", R.drawable.france),
            CountryModel(5, "Germany", "This is the Germany Flag", R.drawable.germany),
            CountryModel(6, "Ireland", "This is the Ireland Flag", R.drawable.ireland),
            CountryModel(7, "Italy", "This is the Italy Flag", R.drawable.italy),
            CountryModel(8, "Netherlands", "This is the Netherlands Flag", R.drawable.netherlands),
            CountryModel(9, "Romania", "This is the Romania Flag", R.drawable.romania),
            CountryModel(10, "Slovakia", "This is the Slovakia Flag", R.drawable.slovakia),
            CountryModel(11, "Spain", "This is the Spain Flag", R.drawable.spain),
            CountryModel(11, "Turkey", "This is the Turkey Flag", R.drawable.turkey),
        )
    }

    return countryList
}