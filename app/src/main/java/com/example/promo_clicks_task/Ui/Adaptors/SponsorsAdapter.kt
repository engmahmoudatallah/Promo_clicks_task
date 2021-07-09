package com.example.promo_clicks_task.Ui.Adaptors

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.BR
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.databinding.RowSponsorsBinding
import com.example.promo_clicks_task.models.Sponsor


class SponsorsAdapter(val list: List<Sponsor>) :
    RecyclerView.Adapter<SponsorsAdapter.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding: RowSponsorsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_sponsors,
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


    class ViewHolderClass(binding: RowSponsorsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var rowSponsorsBinding: RowSponsorsBinding = binding
        fun bind(obj: Any?) {
            rowSponsorsBinding.setVariable(BR.model, obj)
            rowSponsorsBinding.executePendingBindings()
        }


    }

}