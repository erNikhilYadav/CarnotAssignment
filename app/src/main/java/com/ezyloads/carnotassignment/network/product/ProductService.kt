package com.ezyloads.carnotassignment.network.product

import com.ezyloads.carnotassignment.BuildConfig
import com.ezyloads.carnotassignment.constant.APIConstants
import com.ezyloads.carnotassignment.constant.APIConstants.RESPONSE_FORMAT
import com.ezyloads.carnotassignment.network.product.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */
interface ProductService {
    @GET(APIConstants.RESOURCES)
    suspend fun getProducts(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = RESPONSE_FORMAT,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("filters") filters: String?,
    ): ProductResponse
}