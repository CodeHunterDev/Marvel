package com.amnah.marvelapp.di

import com.amnah.marvelapp.BuildConfig
import com.amnah.marvelapp.data.remote.AuthInterceptor
import com.amnah.marvelapp.data.remote.MarvelApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun marvelService(
        okHttpClient: OkHttpClient,
        GsonConverterFactory: GsonConverterFactory
    ): MarvelApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory)
            .client(okHttpClient)
            .build()

        return retrofit.create(MarvelApiService::class.java)
    }

    @Singleton
    @Provides
    fun providerOkhttpClient(
        authInterceptor: AuthInterceptor,
        provideLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(provideLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun authInterceptor(): AuthInterceptor = AuthInterceptor()

    @Singleton
    @Provides
    fun provideLoggInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun addProvideGson() = GsonConverterFactory.create()
}