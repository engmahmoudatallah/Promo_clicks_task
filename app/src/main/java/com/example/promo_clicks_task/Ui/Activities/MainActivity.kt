package com.example.promo_clicks_task.Ui.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.promo_clicks_task.Ui.Adaptors.HomeAdapter
import com.example.promo_clicks_task.Ui.Adaptors.SlidersAdapter
import com.example.promo_clicks_task.Utils.TestData
import com.example.promo_clicks_task.databinding.ActivityMainBinding
import com.example.promo_clicks_task.viewModel.SimpleModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("ShowToast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(SimpleModel::class.java)
        binding.baseInfo.mainViewModel = viewModel
        binding.lifecycleOwner = this


        binding.rvSliders.setHasFixedSize(true)
        binding.rvSliders.layoutManager =
            GridLayoutManager(
                this, 1, GridLayoutManager.HORIZONTAL, false
            )
        val testData = TestData()
        val adapter = SlidersAdapter(testData.getImagesSliderListOffline())
        binding.rvSliders.adapter = adapter


        binding.rvHomeList.setHasFixedSize(true)
        binding.rvHomeList.layoutManager =
            GridLayoutManager(
                this, 1, GridLayoutManager.VERTICAL, false
            )
        val adapter2 = HomeAdapter()
        binding.rvHomeList.adapter = adapter2


    }

}

