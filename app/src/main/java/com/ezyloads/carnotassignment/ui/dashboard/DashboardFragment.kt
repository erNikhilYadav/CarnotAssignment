package com.ezyloads.carnotassignment.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezyloads.carnotassignment.R
import com.ezyloads.carnotassignment.databinding.DashboardFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author: Nikhil Yadav
 * @Date: 09-09-2022.
 */

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private lateinit var binding: DashboardFragmentBinding
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.dashboard_fragment, container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
    }

    private fun observers() {
        dashboardViewModel.isProgress.observe(viewLifecycleOwner) {
            if (it) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }
        }

        val pagingAdapter = ProductPagingAdapter()
        binding.adapter = pagingAdapter

        dashboardViewModel.products.observe(viewLifecycleOwner) {
            dashboardViewModel.isProgress.value = false
            pagingAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        binding.submitBtn.setOnClickListener {
            if (!binding.searchEt.text.isNullOrEmpty()) {
                dashboardViewModel.isProgress.value = true
                dashboardViewModel.search(binding.searchEt.text.toString())
            } else {
                dashboardViewModel.isProgress.value = true
                dashboardViewModel.search("")
            }
        }
    }
}