package com.example.movielistapp.di

import com.example.movielistapp.Constants
import com.example.movielistapp.Constants.BASE_URL
import com.example.movielistapp.data.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOpenWeatherApi(): RetrofitService {
        if (RetrofitService.retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            RetrofitService.retrofitService = retrofit.create(RetrofitService::class.java)
        }
        return RetrofitService.retrofitService!!
    }
}
