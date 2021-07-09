package com.example.promo_clicks_task.Ui.Adaptors

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.promo_clicks_task.Listeners.HomeAdapterListener
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.models.HotProductPaidStatu
import com.example.promo_clicks_task.models.Sponsor
import com.example.promo_clicks_task.models.Vendor

class HomeAdapter(
    val sponsorList: List<Sponsor>,
    val vendorList : List<Vendor>,
    val hotProductPaidList : List<HotProductPaidStatu>

) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val SPONSORS: Int = 0
    val VENDORS: Int = 1
    val HOT_SELLER: Int = 2

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
                return SponsorsClass(view, sponsorList)
            }
            VENDORS -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_recycler_home, parent, false)
                return VendorsClass(view,vendorList)
            }
            HOT_SELLER -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_recycler_home, parent, false)
                return HotSellerClass(view,hotProductPaidList)
            }

            else -> return SponsorsClass(view,sponsorList)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType: Int = getItemViewType(position)
        val listener: HomeAdapterListener

        when (viewType) {
            SPONSORS -> {
                listener = SponsorsClass(holder.itemView, sponsorList)
                listener.onCreate()
            }
            VENDORS -> {
                listener = VendorsClass(holder.itemView,vendorList)
                listener.onCreate()
            }
            HOT_SELLER -> {
                listener = HotSellerClass(holder.itemView,hotProductPaidList)
                listener.onCreate()
            }
        }

    }

    class SponsorsClass(itemView: View, listSponsor: List<Sponsor>) :
        RecyclerView.ViewHolder(itemView), HomeAdapterListener {

        private val sponsers: List<Sponsor> = listSponsor

        @SuppressLint("SetTextI18n")
        override fun onCreate() {
            val title: TextView = itemView.findViewById(R.id.tv_title_home)
            val recyclerView: RecyclerView = itemView.findViewById(R.id.rv_home)

            title.text = "Sponsors"

            recyclerView.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(itemView.context,RecyclerView.HORIZONTAL,false
                )
                adapter = SponsorsAdapter(sponsers)

            }





        }

    }

    class VendorsClass(itemView: View, listOfVendor: List<Vendor>) : RecyclerView.ViewHolder(itemView), HomeAdapterListener {

        private val vendors : List<Vendor> = listOfVendor
        @SuppressLint("SetTextI18n")
        override fun onCreate() {
            val title: TextView = itemView.findViewById(R.id.tv_title_home)
            val recyclerView: RecyclerView = itemView.findViewById(R.id.rv_home)

            title.text = "Vendors"


            recyclerView.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(itemView.context,RecyclerView.HORIZONTAL,false
                )
                adapter = VendorsAdapter(vendors)

            }
        }

    }

    class HotSellerClass(itemView: View, hotProductPaidList: List<HotProductPaidStatu>) : RecyclerView.ViewHolder(itemView), HomeAdapterListener {

        private val products : List<HotProductPaidStatu> = hotProductPaidList
        @SuppressLint("SetTextI18n")
        override fun onCreate() {
            val title: TextView = itemView.findViewById(R.id.tv_title_home)
            val recyclerView: RecyclerView = itemView.findViewById(R.id.rv_home)

            title.text = "Hot Discount"

            recyclerView.apply{
                setHasFixedSize(true)
//                layoutManager = LinearLayoutManager(itemView.context,RecyclerView.VERTICAL,false)
                layoutManager = GridLayoutManager(itemView.context,2,GridLayoutManager.VERTICAL,false)
                adapter = HotDiscountAdapter(products)

            }



        }

    }

    override fun getItemCount(): Int {
        return 3
    }


}