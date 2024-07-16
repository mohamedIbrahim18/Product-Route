package com.example.productapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Category
import com.example.domain.model.ProductsItem
import com.example.productapp.databinding.ItemProductBinding

class ProductAdapter(private var products : List<ProductsItem?>?)
    :RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products!!.get(position))
    }


    override fun getItemCount(): Int {
        return products?.size?:0

    }

    fun bindCategories(products: List<ProductsItem?>?) {
        this.products = products
        notifyDataSetChanged()
    }



    class  ViewHolder(private val itemBinding :ItemProductBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        fun bind(product:ProductsItem?){
            itemBinding.product = product
            itemBinding.executePendingBindings()
        }
    }
}