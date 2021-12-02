package com.amnah.marvelapp.data.remote

import com.amnah.marvelapp.BuildConfig
import com.amnah.marvelapp.data.remote.response.BaseMarvelResponse
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    suspend fun getCharacters(): Response<BaseMarvelResponse<CharacterResult>>

    companion object {
        private val okHttpClient = okhttp3.OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }).addInterceptor(AuthInterceptor())
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(MarvelService::class.java)
    }
}