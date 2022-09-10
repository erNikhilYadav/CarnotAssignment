package com.ezyloads.carnotassignment.network.product

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ezyloads.carnotassignment.network.product.response.ProductResponse
import retrofit2.HttpException
import java.io.IOException

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */
class ProductPagingSource(
    private val productService: ProductService,
    private val query: String
) : PagingSource<Int, ProductResponse.Record>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ProductResponse.Record> {
        return try {
            val position = params.key ?: 0
            val response = productService.getProducts(
                offset = position,
                limit = params.loadSize,
                filters = query
            )

            LoadResult.Page(
                data = response.records,
                if (position == 0) null else 0,
                if (response.records.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, ProductResponse.Record>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}