package com.jgarcia.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jgarcia.domain.util.Result
import com.jgarcia.presentation.databinding.FragmentProductListByQueryBinding
import com.jgarcia.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private lateinit var fragmentProductListByQueryBinding: FragmentProductListByQueryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentProductListByQueryBinding = FragmentProductListByQueryBinding.inflate(inflater, container, false)
        return fragmentProductListByQueryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        addSubscriptions()
    }

    private fun setListeners() {
        fragmentProductListByQueryBinding.ivSearch.setOnClickListener {
            if (fragmentProductListByQueryBinding.etSearchProduct.text.isNotEmpty()) {
                mainViewModel.searchByTerm(fragmentProductListByQueryBinding.etSearchProduct.text.toString())
            }
        }
    }

    private fun addSubscriptions() {
        // product list selector
        mainViewModel.getProductList().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> showLoader()
                is Result.Success -> {
                    if (result.data.isNotEmpty()) {
                        //adapter
                        showProductListView()
                    } else {

                    }
                }
                is Result.Error -> showError()
            }
        })
    }

    private fun showLoader() {
        fragmentProductListByQueryBinding.loadingContainer.root.visibility = View.VISIBLE
        fragmentProductListByQueryBinding.errorContainer.root.visibility = View.GONE
        fragmentProductListByQueryBinding.rvProductList.visibility = View.GONE
    }

    private fun showError() {
        fragmentProductListByQueryBinding.loadingContainer.root.visibility = View.GONE
        fragmentProductListByQueryBinding.errorContainer.root.visibility = View.VISIBLE
        fragmentProductListByQueryBinding.rvProductList.visibility = View.GONE
    }

    private fun showProductListView() {
        fragmentProductListByQueryBinding.loadingContainer.root.visibility = View.GONE
        fragmentProductListByQueryBinding.errorContainer.root.visibility = View.GONE
        fragmentProductListByQueryBinding.rvProductList.visibility = View.VISIBLE
    }
}