package com.example.promo_clicks_task.Ui.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Model.VendorsModel
import com.example.promo_clicks_task.R
import com.squareup.picasso.Picasso


class VendorsAdapter(private var list: ArrayList<VendorsModel>) :
    RecyclerView.Adapter<VendorsAdapter.InfoClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoClass {
        var view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_vendors, parent, false)
        return InfoClass(view)

    }

    override fun onBindViewHolder(holder: InfoClass, position: Int) {
        val sliderModel: VendorsModel = list[position]

        Picasso.get().load(sliderModel.pic_url).fit().into(holder.picture)

    }


    override fun getItemCount(): Int {
        return list.size
    }

    class InfoClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var picture: ImageView = itemView.findViewById(R.id.imv_vendor_icon)


    }


}