package com.jgarcia.presentation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.presentation.databinding.LayoutProductPreviewItemBinding
import com.jgarcia.presentation.util.loadImageFromPath

class ProductListAdapter(private val onItemClicked: (productPreview: ProductPreview) -> Unit) : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private var productsList: ArrayList<ProductPreview> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val itemBinding = LayoutProductPreviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    class ProductListViewHolder(private val layoutProductPreviewItemBinding: LayoutProductPreviewItemBinding) : RecyclerView.ViewHolder(layoutProductPreviewItemBinding.root) {
        fun bind(productPreview: ProductPreview) {
            layoutProductPreviewItemBinding.tvTitle.text = productPreview.title
            layoutProductPreviewItemBinding.tvPrice.text = "$${productPreview.price}"
            layoutProductPreviewItemBinding.tvFreeShipping.visibility = if (productPreview.hasFreeShipping) View.VISIBLE else View.GONE
            productPreview.thumbnailUrl?.let { layoutProductPreviewItemBinding.ivThumbnail.loadImageFromPath(it) }
        }
    }
}