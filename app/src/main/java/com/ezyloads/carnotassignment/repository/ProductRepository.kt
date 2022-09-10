package com.ezyloads.carnotassignment.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.ezyloads.carnotassignment.network.product.ProductPagingSource
import com.ezyloads.carnotassignment.network.product.ProductService
import com.ezyloads.carnotassignment.network.product.response.ProductResponse
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */

@Singleton
class ProductRepository
@Inject
constructor(
    private val productService: ProductService
) {

    fun getProducts(query: String): LiveData<PagingData<ProductResponse.Record>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { ProductPagingSource(productService, query) }
        ).liveData
    }

}