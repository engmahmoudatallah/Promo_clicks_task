package com.example.promo_clicks_task.Ui.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.promo_clicks_task.R
import com.example.promo_clicks_task.Ui.Adaptors.ProductReviewAdapter
import com.example.promo_clicks_task.Ui.Adaptors.RelatedProductsAdapter
import com.example.promo_clicks_task.Utils.TestData
import com.example.promo_clicks_task.databinding.ActivityProdectDetailsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ProdectDetailsActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {

    lateinit var binding: ActivityProdectDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdectDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * This make initializes for the galley images View to work on OnCLick Method
         * @see onClick
         * @see initGalleyResources
         * */
        initGalleyResources()

        configurationToolbar()

        /**
         * set reviews data list
         *  @see reviewsData
         * */
        reviewsData()

        /**
         * set related product data list
         *  @see relatedProductsData
         * */
        relatedProductsData()


        //-- set mapping view data --//
        //- Get the SupportMapFragment and request notification when the map is ready to be used.-//
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)


    }

    override fun onMapReady(p0: GoogleMap) {
        val latLan = LatLng(24.807803359228078, 46.63013259245146)
        p0.addMarker(
            MarkerOptions()
                .position(latLan)
                .title("Mall of Arabia")

        )
        p0.moveCamera(CameraUpdateFactory.newLatLng(latLan))
        p0.maxZoomLevel
    }


    @SuppressLint("SetTextI18n")
    fun reviewsData() {
        val testData = TestData()
        binding.rvReviews.tvTitleHome.text = "Reviews"
        binding.rvReviews.rvHome.setHasFixedSize(true)
        binding.rvReviews.rvHome.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        val adapter = ProductReviewAdapter(testData.getProductReviewDetailsData())
        binding.rvReviews.rvHome.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    fun relatedProductsData() {
        val testData = TestData()
        binding.rvRelatedProducts.tvTitleHome.text = "Related products"
        binding.rvRelatedProducts.rvHome.setHasFixedSize(true)
        binding.rvRelatedProducts.rvHome.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        val adapter2 = RelatedProductsAdapter(testData.getRelatedProductsDataList())
        binding.rvRelatedProducts.rvHome.adapter = adapter2
    }

    fun initGalleyResources() {
        binding.galley.imvProduct1.setOnClickListener(this)
        binding.galley.imvProduct2.setOnClickListener(this)
        binding.galley.imvProduct3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imv_product_1 -> {

                setDrawableSelected(
                    binding.galley.imvProduct1,
                    binding.galley.imvProduct2,
                    binding.galley.imvProduct3
                )
            }
            R.id.imv_product_2 -> {
                setDrawableSelected(
                    binding.galley.imvProduct2,
                    binding.galley.imvProduct1,
                    binding.galley.imvProduct3
                )
            }
            R.id.imv_product_3 -> {
                setDrawableSelected(
                    binding.galley.imvProduct3,
                    binding.galley.imvProduct2,
                    binding.galley.imvProduct1
                )
            }


        }
    }


   private fun setDrawableSelected(image: ImageView, second: ImageView, third: ImageView) {
        image.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.product_select_review_image_shape
            )
        )
        second.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.product_select_review_image_non_shape
            )
        )
        third.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.product_select_review_image_non_shape
            )
        )

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