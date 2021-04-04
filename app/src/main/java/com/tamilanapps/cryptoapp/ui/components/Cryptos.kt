package com.tamilanapps.cryptoapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.tamilanapps.cryptoapp.data.model.CryptoResponse

@Composable
fun DisplayCryptos(cryptoResponseData: CryptoResponse){
    LazyColumn{
        itemsIndexed(
            items = cryptoResponseData
        ){index, item ->

            DisplayCryptoCard(cryptoResponseData = item)

        }
    }
}
