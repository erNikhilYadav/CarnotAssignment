package com.ezyloads.carnotassignment.di

import com.ezyloads.carnotassignment.network.product.ProductService
import com.ezyloads.carnotassignment.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(productService: ProductService): ProductRepository =
        ProductRepository(productService)

}