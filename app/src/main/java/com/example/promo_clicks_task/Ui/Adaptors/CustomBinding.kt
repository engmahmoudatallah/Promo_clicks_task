package com.example.promo_clicks_task.Ui.Adaptors

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter( "loadimage")
fun bindingImage(userImageView :ImageView,imageUri : String){
    Glide.with(userImageView.context)
        .load(imageUri)
        .into(userImageView)
}

fun bindingImage(userImageView: ImageView, image: Int) {
    Glide.with(userImageView.context)
        .load(image)
        .into(userImageView)
}
