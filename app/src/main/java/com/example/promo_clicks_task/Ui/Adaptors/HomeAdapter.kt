package com.example.promo_clicks_task.Ui.Adaptors

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Listeners.HomeAdapterListener
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.Utils.TestData

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val SPONSORS: Int = 0
    val VENDORS: Int = 1
    val HOT_SELLER: Int = 2

    init {


    }


    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return SPONSORS
        } else if (position == 1) {
            return VENDORS
        } else if (position == 2) {
            return HOT_SELLER
        } else {
            return SPONSORS
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var view: View
        when (viewType) {
            SPONSORS -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_recycler_home, parent, false)
                return SponsorsClass(view)
            }
            VENDORS -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_recycler_home, parent, false)
                return VendorsClass(view)
            }
            HOT_SELLER -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_recycler_home, parent, false)
                return HotSellerClass(view)
            }

            else -> return SponsorsClass(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType: Int = getItemViewType(position)
        val listener: HomeAdapterListener

        when (viewType) {
            SPONSORS -> {
                listener = SponsorsClass(holder.itemView)
                listener.onCreate()
            }
            VENDORS -> {
                listener = VendorsClass(holder.itemView)
                listener.onCreate()
            }
            HOT_SELLER -> {
                listener = HotSellerClass(holder.itemView)
                listener.onCreate()
            }
        }

    }

    class SponsorsClass(itemView: View) : RecyclerView.ViewHolder(itemView), HomeAdapterListener {

        @SuppressLint("SetTextI18n")
        override fun onCreate() {
            val title: TextView = itemView.findViewById(R.id.tv_title_home)
            val recyclerView: RecyclerView = itemView.findViewById(R.id.rv_home)
            val testData = TestData()

            title.text = "Sponsors"

            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(
                itemView.context, 1, GridLayoutManager.HORIZONTAL, false
            )
            val adapter = SponsorsAdapter(testData.getImagesSponsorsListOffline())
            recyclerView.adapter = adapter


        }

    }

    class VendorsClass(itemView: View) : RecyclerView.ViewHolder(itemView), HomeAdapterListener {

        @SuppressLint("SetTextI18n")
        override fun onCreate() {
            val title: TextView = itemView.findViewById(R.id.tv_title_home)
            val recyclerView: RecyclerView = itemView.findViewById(R.id.rv_home)

            title.text = "Vendors"

            val testData = TestData()

            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(
                itemView.context, 1, GridLayoutManager.HORIZONTAL, false
            )
            val adapter = VendorsAdapter(testData.getImagesVendorsListOffline())
            recyclerView.adapter = adapter
        }

    }

    class HotSellerClass(itemView: View) : RecyclerView.ViewHolder(itemView), HomeAdapterListener {

        @SuppressLint("SetTextI18n")
        override fun onCreate() {
            val title: TextView = itemView.findViewById(R.id.tv_title_home)
            val recyclerView: RecyclerView = itemView.findViewById(R.id.rv_home)

            title.text = "Hot Discount"

            val testData = TestData()

            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(
                itemView.context, 2, GridLayoutManager.VERTICAL, false
            )
            val adapter = HotDiscountAdapter(testData.getHotDiscountDataListOffline())
            recyclerView.adapter = adapter




        }

    }

    override fun getItemCount(): Int {
        return 3
    }


}