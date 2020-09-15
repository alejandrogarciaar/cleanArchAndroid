package com.jgarcia.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.domain.util.Result
import com.jgarcia.presentation.databinding.FragmentProductListByQueryBinding
import com.jgarcia.presentation.util.hideKeyboard
import com.jgarcia.presentation.view.adapters.ProductListAdapter
import com.jgarcia.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private lateinit var fragmentProductListByQueryBinding: FragmentProductListByQueryBinding
    private lateinit var productListAdapter: ProductListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentProductListByQueryBinding = FragmentProductListByQueryBinding.inflate(inflater, container, false)
        return fragmentProductListByQueryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setItemDecoration()
        setBuilder()
        addSubscriptions()
    }

    private fun setListeners() {
        fragmentProductListByQueryBinding.ivSearch.setOnClickListener {
            if (fragmentProductListByQueryBinding.etSearchProduct.text.isNotEmpty()) {
                activity?.hideKeyboard()
                mainViewModel.searchByTerm(fragmentProductListByQueryBinding.etSearchProduct.text.toString())
            }
        }
    }

    private fun setItemDecoration() {
        with(fragmentProductListByQueryBinding.rvProductList) {
            layoutManager = LinearLayoutManager(this.context)
            addItemDecoration(DividerItemDecoration(this.context, RecyclerView.VERTICAL))
        }
    }

    private fun setBuilder() {
        productListAdapter = ProductListAdapter { navigateToDetailView(it) }
        fragmentProductListByQueryBinding.rvProductList.adapter = productListAdapter
    }

    private fun addSubscriptions() {
        mainViewModel.getProductList().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> showLoader()
                is Result.Success -> {
                    if (result.data.isNotEmpty()) {
                        productListAdapter.setItems(result.data)
                        showProductListView()
                    } else {
                        showError()
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

    private fun navigateToDetailView(productPreview: ProductPreview) {
        val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(productId = productPreview.id!!)
        findNavController().navigate(action)
    }
}