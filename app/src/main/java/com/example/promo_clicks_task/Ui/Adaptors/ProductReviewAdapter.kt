package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Model.ReviewsModel
import com.example.promo_clicks_task.R
import com.squareup.picasso.Picasso

class ProductReviewAdapter(private var list: ArrayList<ReviewsModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_rv_reviews, parent, false)
        return ReviewsClass(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: ReviewsModel = list[position]
        var reviewsClass = ReviewsClass(holder.itemView)

        reviewsClass.userName.text = model.userName
        reviewsClass.userReview.text = model.userReview
        reviewsClass.ratingBar.rating = model.ratingNumber

        Picasso.get().load(model.pic_url).fit().into(reviewsClass.profile_pic)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ReviewsClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var userName: TextView = itemView.findViewById(R.id.tv_username)
        var profile_pic: ImageView = itemView.findViewById(R.id.user_picture)
        var userReview: TextView = itemView.findViewById(R.id.tv_user_review)
        var ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
    }
}