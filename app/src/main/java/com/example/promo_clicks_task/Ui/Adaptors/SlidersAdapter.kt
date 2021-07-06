package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Listeners.OnClickItem
import com.example.promo_clicks_task.Model.SliderModel
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.databinding.CustomImageSliderLayoutBinding


class SlidersAdapter(var list: ArrayList<SliderModel>) :
    RecyclerView.Adapter<SlidersAdapter.ViewHolderClass>(),
    OnClickItem {


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

        bindingImage(holder.itemRowRvReviewsBinding.imvSlider,R.drawable.image_offer)

        holder.bind(model)
        holder.itemRowRvReviewsBinding.apply {
            //itemClickListener = this@SlidersAdapter
        }
    }

    override fun getItemCount(): Int {
        return if (list.size > 0) list.size else 0
    }


     class ViewHolderClass(binding: CustomImageSliderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var itemRowRvReviewsBinding: CustomImageSliderLayoutBinding = binding
        fun bind(obj: Any?) {
            itemRowRvReviewsBinding.setVariable(BR.mainViewModel, obj)
            itemRowRvReviewsBinding.executePendingBindings()
        }
    }

    override fun onCLickItem() {
        TODO("Not yet implemented")
    }


}