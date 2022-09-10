package com.ezyloads.carnotassignment.di

import com.ezyloads.carnotassignment.network.product.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit.Builder): ProductService =
        retrofit.build().create(ProductService::class.java)

}