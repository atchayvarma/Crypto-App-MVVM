package com.tamilanapps.cryptoapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import com.tamilanapps.cryptoapp.data.model.CryptoResponseItem
import com.bumptech.glide.request.RequestOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.tamilanapps.cryptoapp.theme.Montserrat


@Composable
fun DisplayCryptoCard(cryptoResponseData: CryptoResponseItem){

    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        Card(
            elevation = 20.dp,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(10.dp)
        ) {

            Row{
                DisplayCryptoDetails(cryptoResponseData = cryptoResponseData)

            }

        }

    }

}

@Composable
fun DisplayCryptoDetails(cryptoResponseData: CryptoResponseItem){

       Row(
     verticalAlignment = Alignment.CenterVertically
       ){
           GlideImage(
               data = cryptoResponseData.image,
               modifier = Modifier
                   .width(60.dp)
                   .height(60.dp)
                   .padding(10.dp),
               contentDescription = "My content description",
               requestBuilder = {
                   val options = RequestOptions()

                   options.centerCrop()

                   apply(options)
               },
           )

           Column{
               Text(
                   text = cryptoResponseData.name,
                   fontFamily = Montserrat,
                   fontSize = 20.sp
               )
               Text(
                   text = cryptoResponseData.symbol.toUpperCase(),
                   fontFamily = Montserrat,
                   fontSize = 10.sp
               )
           }
       }

}

@Composable
fun DisplayCryptoValues(cryptoResponseData: CryptoResponseItem){

        Column{
            Text(
                text = "Rs:${cryptoResponseData.current_price.toString()}",
                fontFamily = Montserrat,
                fontSize = 20.sp
            )


    }

}