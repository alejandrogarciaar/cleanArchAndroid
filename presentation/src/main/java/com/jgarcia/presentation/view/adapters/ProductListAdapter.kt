package com.jgarcia.presentation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.presentation.databinding.LayoutProductPreviewTemplateBinding
import com.jgarcia.presentation.util.loadImageFromPath

class ProductListAdapter(private val onItemClicked: (productPreview: ProductPreview) -> Unit) : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private var productsList: ArrayList<ProductPreview> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val itemBinding = LayoutProductPreviewTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val currentProductView = productsList[position]
        holder.bind(currentProductView)
        holder.itemView.setOnClickListener { onItemClicked(currentProductView) }
    }

    override fun getItemCount() = productsList.size

    override fun getItemViewType(position: Int): Int = position

    fun setItems(newProductList: List<ProductPreview>) {
        this.productsList.clear()
        this.productsList.addAll(newProductList)
        this.notifyDataSetChanged()
    }

    class ProductListViewHolder(private val layoutProductPreviewTemplateBinding: LayoutProductPreviewTemplateBinding) : RecyclerView.ViewHolder(layoutProductPreviewTemplateBinding.root) {
        fun bind(productPreview: ProductPreview) {
            layoutProductPreviewTemplateBinding.tvTitle.text = productPreview.title
            layoutProductPreviewTemplateBinding.tvPrice.text = "$${productPreview.price}"
            layoutProductPreviewTemplateBinding.tvFreeShipping.visibility = if (productPreview.hasFreeShipping) View.VISIBLE else View.GONE
            productPreview.thumbnailUrl?.let { layoutProductPreviewTemplateBinding.ivThumbnail.loadImageFromPath(it) }
        }
    }
}