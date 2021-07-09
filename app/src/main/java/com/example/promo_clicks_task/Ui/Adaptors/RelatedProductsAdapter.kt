package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.BR
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.databinding.RowRvRelatedProductsBinding
import com.example.promo_clicks_task.models.RelatedProduct

class RelatedProductsAdapter(private var list: List<RelatedProduct>) :
    RecyclerView.Adapter<RelatedProductsAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding: RowRvRelatedProductsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_rv_related_products,
                parent,
                false
            )
        return ViewHolderClass(binding)

    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val model = list[position]
        holder.bind(model)
    }


    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderClass(binding: RowRvRelatedProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var rowRvRelatedProductsBinding: RowRvRelatedProductsBinding = binding
        fun bind(obj: Any?) {
            rowRvRelatedProductsBinding.setVariable(BR.model, obj)
            rowRvRelatedProductsBinding.executePendingBindings()
        }


    }
}