package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.BR
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.databinding.RowVendorsBinding
import com.example.promo_clicks_task.models.Vendor


class VendorsAdapter(private var list: List<Vendor>) :
    RecyclerView.Adapter<VendorsAdapter.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding: RowVendorsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_vendors,
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


    class ViewHolderClass(binding: RowVendorsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var rowVendorsBinding: RowVendorsBinding = binding
        fun bind(obj: Any?) {
            rowVendorsBinding.setVariable(BR.model, obj)
            rowVendorsBinding.executePendingBindings()
        }


    }


}