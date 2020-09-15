package com.jgarcia.presentation.view.fragments

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.domain.util.ErrorType
import com.jgarcia.domain.util.Result
import com.jgarcia.presentation.R
import com.jgarcia.presentation.databinding.FragmentProductDetailBinding
import com.jgarcia.presentation.view.adapters.ImagesCollectionPagerAdapter
import com.jgarcia.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    private val args: ProductDetailFragmentArgs by navArgs()
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var fragmentProductDetailBinding: FragmentProductDetailBinding
    private lateinit var imagesCollectionPagerAdapter: ImagesCollectionPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentProductDetailBinding = FragmentProductDetailBinding.inflate(layoutInflater, container, false)
        addSubscriptions()
        return fragmentProductDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getProductDetail()
    }

    private fun addSubscriptions() {
        mainViewModel.getProductDetail().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> setLoadingView()
                is Result.Success -> {
                    inflateDetailedView(result.data)
                    setDetailView()
                }
                is Result.Error -> {
                    setErrorView()
                }
            }
        })
    }


    private fun getProductDetail() {
        mainViewModel.getProductDetail(args.productId)
    }

    private fun inflateDetailedView(data: ProductDetail) {
        imagesCollectionPagerAdapter = ImagesCollectionPagerAdapter(data.images, childFragmentManager)
        fragmentProductDetailBinding.imagesViewPager.adapter = imagesCollectionPagerAdapter

        fragmentProductDetailBinding.soldQuantity.text = getString(R.string.sold_quantity_label, data.soldQuantity.toString())
        fragmentProductDetailBinding.title.text = data.title
        fragmentProductDetailBinding.price.text = getString(R.string.price_label, data.price.toString())

        val warrantyString = Html.fromHtml(getString(R.string.warranty_label, data.warranty), FROM_HTML_MODE_LEGACY)
        fragmentProductDetailBinding.warranty.text = warrantyString

        val tags = data.tags.joinToString(separator = ", ")
        val tagsString = Html.fromHtml(getString(R.string.tags_label, tags), FROM_HTML_MODE_LEGACY)
        fragmentProductDetailBinding.tags.text = tagsString

        if (data.description.isNullOrEmpty().not()) {
            val description = Html.fromHtml(getString(R.string.description_label, data.description), FROM_HTML_MODE_LEGACY)
            fragmentProductDetailBinding.description.text = description
            fragmentProductDetailBinding.description.visibility = View.VISIBLE
        } else {
            fragmentProductDetailBinding.description.visibility = View.VISIBLE
        }

        if (data.features.isNullOrEmpty().not()) {
            val features =
                data.features
                    ?.map { it.text }
                    ?.joinToString(separator = "<br><br>")

            val featuresString = Html.fromHtml(getString(R.string.features_label, features), FROM_HTML_MODE_LEGACY)
            fragmentProductDetailBinding.features.text = featuresString
            fragmentProductDetailBinding.features.visibility = View.VISIBLE
        } else fragmentProductDetailBinding.features.visibility = View.GONE
    }

    private fun setLoadingView() {
        fragmentProductDetailBinding.detailContainer.visibility = View.GONE
        fragmentProductDetailBinding.progressContainer.root.visibility = View.VISIBLE
        fragmentProductDetailBinding.errorView.root.visibility = View.GONE
    }

    private fun setErrorView() {
        fragmentProductDetailBinding.detailContainer.visibility = View.GONE
        fragmentProductDetailBinding.progressContainer.root.visibility = View.GONE
        fragmentProductDetailBinding.errorView.root.visibility = View.VISIBLE
        fragmentProductDetailBinding.errorView.tvError.text = getString(R.string.something_went_wrong)
    }

    private fun setDetailView() {
        fragmentProductDetailBinding.detailContainer.visibility = View.VISIBLE
        fragmentProductDetailBinding.progressContainer.root.visibility = View.GONE
        fragmentProductDetailBinding.errorView.root.visibility = View.GONE
    }
}