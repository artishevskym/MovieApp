package com.artishevskym.movieapp.feature.show

import com.artishevskym.movieapp.feature.show.data.network.service.ShowRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Config.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ShowRetrofitService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShowRetrofitService::class.java)

}