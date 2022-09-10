package com.ezyloads.carnotassignment.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ezyloads.carnotassignment.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */

@HiltViewModel
class DashboardViewModel
@Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    var isProgress = MutableLiveData<Boolean>()
    private val currentQuery = MutableLiveData(DEFAULT)

    val products = currentQuery.switchMap {
        productRepository.getProducts(it)
            .cachedIn(viewModelScope)
    }

    fun search(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val DEFAULT = ""
    }

}