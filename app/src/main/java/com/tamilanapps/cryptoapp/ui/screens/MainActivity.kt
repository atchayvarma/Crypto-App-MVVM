package com.tamilanapps.cryptoapp.ui.screens

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tamilanapps.cryptoapp.data.model.CryptoResponse
import com.tamilanapps.cryptoapp.theme.CryptoAppTheme
import com.tamilanapps.cryptoapp.ui.components.DisplayCryptos
import com.tamilanapps.cryptoapp.viewmodels.CryptoViewModel
import com.tamilanapps.kalai2malai.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lateinit var cryptoResponseData:CryptoResponse
        val viewModel  = ViewModelProvider(this).get(CryptoViewModel::class.java)

        viewModel.cryptos.observe(this, Observer {response ->

            when(response){
                is Resource.Success ->
                    response.data?.let{
                        cryptoResponseData = it

                        setContent {

                            BoxWithConstraints(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                            DisplayCryptos(cryptoResponseData = cryptoResponseData)
                            }


                        }

                    }

                is Resource.Loading -> Toast.makeText(this,"Loading...",LENGTH_SHORT).show()

                is Resource.Error -> Toast.makeText(this,"Error 😞",LENGTH_SHORT).show()
            }





        })

    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoAppTheme {

    }
}