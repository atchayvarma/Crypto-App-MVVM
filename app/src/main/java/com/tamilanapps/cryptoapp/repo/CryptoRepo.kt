package com.tamilanapps.cryptoapp.repo

import com.tamilanapps.cryptoapp.api.CryptoApi
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CryptoRepo @Inject constructor(
    @Named("CryptoApi")
    var cryptoApi: CryptoApi
){

    suspend fun getCryptos() = cryptoApi.getCryptos()
}