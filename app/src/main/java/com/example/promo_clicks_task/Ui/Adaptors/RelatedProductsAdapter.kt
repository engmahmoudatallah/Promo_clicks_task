package com.example.promo_clicks_task.Ui.Adaptors

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Model.RelatedProductsModel
import com.example.promo_clicks_task.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class RelatedProductsAdapter(private var list: ArrayList<RelatedProductsModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_rv_related_products, parent, false)
        return ReviewsClass(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: RelatedProductsModel = list[position]
        val reviewsClass = ReviewsClass(holder.itemView)

        reviewsClass.oldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        reviewsClass.title.text = model.title
        reviewsClass.oldPrice.text = model.oldPrice
        reviewsClass.realPrice.text = model.realPrice
        reviewsClass.ratingBar.rating = model.ratingNumber

        Picasso.get().load(model.pic_url).fit().into(reviewsClass.productPicture)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ReviewsClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.tv_title)
        var productPicture: ShapeableImageView = itemView.findViewById(R.id.imv_product_pic)
        var oldPrice: TextView = itemView.findViewById(R.id.tv_old_price)
        var realPrice: TextView = itemView.findViewById(R.id.tv_real_price)
        var ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
    }
}