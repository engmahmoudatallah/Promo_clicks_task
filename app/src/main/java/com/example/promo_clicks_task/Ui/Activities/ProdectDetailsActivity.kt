package com.example.promo_clicks_task.Ui.Activities

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.Ui.Adaptors.ProductReviewAdapter
import com.example.promo_clicks_task.Ui.Adaptors.RelatedProductsAdapter
import com.example.promo_clicks_task.databinding.ActivityProdectDetailsBinding
import com.example.promo_clicks_task.models.Products
import com.example.promo_clicks_task.viewModel.ProductsViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso

class ProdectDetailsActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {

    lateinit var binding: ActivityProdectDetailsBinding
    var lat: Double = 666.5
    var lng: Double = 666.5
    var img1: String = ""
    var img2: String = ""
    var img3: String = ""
    var imgMain: String = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdectDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        viewModel.listData.observe(this, {
            if (it.success) {
                setInfoData(it.data.Products)
                binding.rvReviews.rvHome.apply {
                    binding.rvReviews.tvTitleHome.text = "Reviews"
                    setHasFixedSize(true)
                    layoutManager = GridLayoutManager(
                        this@ProdectDetailsActivity,
                        1,
                        GridLayoutManager.VERTICAL,
                        false
                    )
                    adapter = ProductReviewAdapter(it.data.Products.review)
                }

                binding.rvRelatedProducts.rvHome.apply {
                    binding.rvRelatedProducts.tvTitleHome.text = "Related products"
                    setHasFixedSize(true)
                    layoutManager = GridLayoutManager(
                        this@ProdectDetailsActivity,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false

                    )
                    adapter = RelatedProductsAdapter(it.data.Related_product)
                }

                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "error to featch data", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()


        /**
         * This make initializes for the galley images View to work on OnCLick Method
         * @see onClick
         * @see initGalleyResources
         * */


        configurationToolbar()


    }

    fun setInfoData(model: Products) {
        Picasso.get().load(model.Gallary[0].images).fit().into(binding.galley.imvProduct1)
        Picasso.get().load(model.Gallary[1].images).fit().into(binding.galley.imvProduct2)
        Picasso.get().load(model.Gallary[2].images).fit().into(binding.galley.imvProduct3)
        binding.info.tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        binding.info.tvRealPrice.text = model.new_price.toString()
        binding.info.tvOldPrice.text = model.old_price.toString()
        binding.info.tvDate.text = model.exp_date
        binding.info.tvViews.text = model.view.toString()
        binding.info.tvDescription.text = model.description
        binding.contact.tvEmail.text = model.email
        binding.contact.tvPhone.text = model.mobile
        binding.contact.tvLocation.text = model.address
        lat = model.lat.trim().toDouble()
        lng = model.lng.trim().toDouble()
        img1 = model.Gallary[0].images
        img2 = model.Gallary[1].images
        img3 = model.Gallary[2].images
        imgMain = model.image
        Picasso
            .get()
            .load(model.image)
            .fit().into(binding.galley.imvProductMain)
        //-- set mapping view data --//
        //- Get the SupportMapFragment and request notification when the map is ready to be used.-//
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        initGalleyResources()
    }


    override fun onMapReady(map: GoogleMap) {
        Log.w("test_Data_2", "lat : $lat , lng $lng")
        val latLan = LatLng(lat, lng)
        map.addMarker(
            MarkerOptions()
                .position(latLan)
                .title("Mall of Arabia")
        )
        map.moveCamera(CameraUpdateFactory.newLatLng(latLan))

    }


    fun initGalleyResources() {
        binding.galley.imvProduct1.setOnClickListener(this)
        binding.galley.imvProduct2.setOnClickListener(this)
        binding.galley.imvProduct3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imv_product_1 -> {
                setImageSelected(img1)
            }

            R.id.imv_product_2 -> {
                setImageSelected(img2)

            }
            R.id.imv_product_3 -> {
                setImageSelected(img3)

            }


        }
    }


    private fun setImageSelected(
        imgUrl: String
    ) {

        Picasso
            .get()
            .load(imgUrl)
            .placeholder(R.drawable.product_select_review_image_shape)
            .fit().into(binding.galley.imvProductMain)

    }

    private fun configurationToolbar() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}