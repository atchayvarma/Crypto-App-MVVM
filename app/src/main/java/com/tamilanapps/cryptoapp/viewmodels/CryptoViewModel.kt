package com.tamilanapps.cryptoapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamilanapps.cryptoapp.data.model.CryptoResponse
import com.tamilanapps.cryptoapp.repo.CryptoRepo
import com.tamilanapps.kalai2malai.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
   var cryptoRepo: CryptoRepo
):ViewModel() {

  val cryptos:MutableLiveData<Resource<CryptoResponse>> = MutableLiveData()


  fun setCryptos() = viewModelScope.launch {
     cryptos.postValue(Resource.Loading())
     val response = cryptoRepo.getCryptos()
     cryptos.postValue(handleCryptoResponse(response))
  }

  fun handleCryptoResponse(response:Response<CryptoResponse>):Resource<CryptoResponse>{

      if (response.isSuccessful){
         response.body()?.let { cryptoResponse ->
            return Resource.Success(cryptoResponse)
         }
      }

      return Resource.Error(response.message())

   }

    init{

            setCryptos()

    }


}