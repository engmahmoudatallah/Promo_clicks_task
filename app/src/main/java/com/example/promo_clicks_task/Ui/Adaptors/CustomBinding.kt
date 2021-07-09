package com.example.promo_clicks_task.Ui.Adaptors

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.promo_clicks_task.R
import com.squareup.picasso.Picasso

@BindingAdapter("loadimage")
fun bindingImage(userImageView: ImageView, imageUri: String) {
    Picasso.get()
        .load(imageUri)
        .fit()
        .placeholder(R.drawable.ic_downloaded)
        .error(R.drawable.ic_download_faild)
        .into(userImageView)

   /* Glide.with(userImageView.context)
        .load(imageUri)
        .fitCenter()
        .into(userImageView)*/
}


