package com.ezyloads.carnotassignment.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.ezyloads.carnotassignment.R
import com.ezyloads.carnotassignment.network.product.response.ProductResponse

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */
class ProductPagingAdapter() :
    PagingDataAdapter<ProductResponse.Record, ProductViewHolder>(UserComparator) {

    object UserComparator : DiffUtil.ItemCallback<ProductResponse.Record>() {
        override fun areItemsTheSame(
            oldItem: ProductResponse.Record,
            newItem: ProductResponse.Record
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ProductResponse.Record,
            newItem: ProductResponse.Record
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        return ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.product_item_list,
                parent,
                false
            )
        )
    }

}