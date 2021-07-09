package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.BR
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.databinding.CustomImageSliderLayoutBinding
import com.example.promo_clicks_task.models.Slider


class SlidersAdapter(val list: List<Slider>) :
    RecyclerView.Adapter<SlidersAdapter.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding: CustomImageSliderLayoutBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.custom_image_slider_layout,
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


    class ViewHolderClass(binding: CustomImageSliderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var itemCustomImageSliderLayoutBinding: CustomImageSliderLayoutBinding = binding
        fun bind(obj: Any?) {
            itemCustomImageSliderLayoutBinding.setVariable(BR.model, obj)
            itemCustomImageSliderLayoutBinding.executePendingBindings()
        }


    }


}
