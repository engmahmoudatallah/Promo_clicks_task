package com.example.promo_clicks_task.Ui.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.promo_clicks_task.Ui.Adaptors.HomeAdapter
import com.example.promo_clicks_task.Ui.Adaptors.SlidersAdapter
import com.example.promo_clicks_task.databinding.ActivityMainBinding
import com.example.promo_clicks_task.viewModel.HomeViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("ShowToast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.listData.observe(this, {
            if (it.success) {
                binding.rvSliders.apply {
                    setHasFixedSize(true)
                    layoutManager =
                        LinearLayoutManager(
                            this@MainActivity,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    adapter = SlidersAdapter(it.data.Sliders)
                }

                binding.rvHomeList.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter = HomeAdapter(
                        it.data.Sponsors,
                        it.data.vendor,
                        it.data.hot_product_paid_status
                    )
                }
                Toast.makeText(
                    this, it.message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "error to featch data", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()


    }


}

