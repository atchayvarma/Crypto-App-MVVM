package com.tamilanapps.cryptoapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import com.tamilanapps.cryptoapp.data.model.CryptoResponseItem
import com.bumptech.glide.request.RequestOptions
import androidx.compose.ui.Modifier


@Composable
fun DisplayCryptoCard(cryptoResponseData: CryptoResponseItem){

    Card(elevation = 20.dp) {
      DisplayCryptoDetails(cryptoResponseData = cryptoResponseData)
    }

}

@Composable
fun DisplayCryptoDetails(cryptoResponseData: CryptoResponseItem){

   Surface() {
       Row {
           GlideImage(
               data = cryptoResponseData.image,
               modifier = Modifier
                   .fillMaxWidth(0.90f),
               contentDescription = "My content description",
               requestBuilder = {
                   val options = RequestOptions()

                   options.centerCrop()

                   apply(options)
               },
           )
       }
   }
}