package com.example.promo_clicks_task.Ui.Adaptors

import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Model.HotDiscountModel
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.Ui.Activities.ProdectDetailsActivity
import com.squareup.picasso.Picasso


class HotDiscountAdapter(private var list: ArrayList<HotDiscountModel>) :
    RecyclerView.Adapter<HotDiscountAdapter.InfoClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoClass {
        var view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_hot_discount_product, parent, false)
        return InfoClass(view)

    }

    override fun onBindViewHolder(holder: InfoClass, position: Int) {
        val model: HotDiscountModel = list[position]


        holder.oldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        holder.title.text = model.title
        holder.oldPrice.text = model.old_price
        holder.realPrice.text = model.real_price
        holder.date.text = model.date
        holder.ratingBar.rating = model.rating_number

        Picasso.get().load(model.pic_url).fit().into(holder.picture)

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, ProdectDetailsActivity::class.java)
            v.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class InfoClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.tv_title)
        var oldPrice: TextView = itemView.findViewById(R.id.tv_old_price)
        var realPrice: TextView = itemView.findViewById(R.id.tv_real_price)
        var date: TextView = itemView.findViewById(R.id.tv_date)
        var ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
        var picture: ImageView = itemView.findViewById(R.id.imv_hot_discount_product)


    }


}