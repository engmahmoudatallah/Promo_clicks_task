package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.BR
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.databinding.RowRvReviewsBinding
import com.example.promo_clicks_task.models.Review

class ProductReviewAdapter(private var list: List<Review>) :
    RecyclerView.Adapter<ProductReviewAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding: RowRvReviewsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_rv_reviews,
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


    class ViewHolderClass(binding: RowRvReviewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var rowRvReviewsBinding: RowRvReviewsBinding = binding
        fun bind(obj: Any?) {
            rowRvReviewsBinding.setVariable(BR.model, obj)
            rowRvReviewsBinding.executePendingBindings()
        }


    }
}