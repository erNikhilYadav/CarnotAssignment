package com.ezyloads.carnotassignment.ui.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.ezyloads.carnotassignment.databinding.ProductItemListBinding
import com.ezyloads.carnotassignment.network.product.response.ProductResponse

/**
 * @Author: Nikhil Yadav
 * @Date: 10-09-2022.
 */
class ProductViewHolder(
    private val binding: ProductItemListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productResponse: ProductResponse.Record) {
        binding.productModel = productResponse
    }
}