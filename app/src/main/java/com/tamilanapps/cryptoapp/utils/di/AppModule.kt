package com.tamilanapps.cryptoapp.utils.di

import com.tamilanapps.cryptoapp.api.CryptoApi
import com.tamilanapps.cryptoapp.data.BASE_URl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Named("CryptoApi")
    @Provides
    fun provideCryptoApi():CryptoApi =
        Retrofit.Builder()
            .baseUrl(BASE_URl)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)

}