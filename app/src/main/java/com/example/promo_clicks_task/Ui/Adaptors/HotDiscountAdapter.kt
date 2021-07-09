package com.example.promo_clicks_task.Ui.Adaptors

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.BR
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.Ui.Activities.ProdectDetailsActivity
import com.example.promo_clicks_task.databinding.RowHotDiscountProductBinding
import com.example.promo_clicks_task.models.HotProductPaidStatu


class HotDiscountAdapter(var list: List<HotProductPaidStatu>) :
    RecyclerView.Adapter<HotDiscountAdapter.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding: RowHotDiscountProductBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_hot_discount_product,
                parent,
                false
            )
        return ViewHolderClass(binding)

    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val model = list[position]
        holder.bind(model)

        holder.itemView.setOnClickListener{v->
            val intent = Intent(holder.itemView.context, ProdectDetailsActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderClass(binding: RowHotDiscountProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var rowHotDiscountProductBinding: RowHotDiscountProductBinding = binding



        fun bind(obj: Any?) {
            rowHotDiscountProductBinding.setVariable(BR.model, obj)
            rowHotDiscountProductBinding.executePendingBindings()

        }

    }




}