package com.example.promo_clicks_task.viewModel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promo_clicks_task.Network.RetrofitClientServices
import com.example.promo_clicks_task.models.ProductsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel() {

    var listData: MutableLiveData<ProductsData> = MutableLiveData()

    fun makeApiCall() {
        val retroApi = RetrofitClientServices.instance
        val call = retroApi.getProductsData(1)

        call.enqueue(object : Callback<ProductsData> {
            override fun onResponse(
                call: Call<ProductsData>,
                response: Response<ProductsData>
            ) {

                if (response.isSuccessful)
                    listData.postValue(response.body())

                else
                    listData.postValue(null)


            }

            override fun onFailure(call: Call<ProductsData>, t: Throwable) {
                t.printStackTrace()
                Log.w("test_Data_2", "${t.message}")
                listData.postValue(null)

            }
        })
    }

}
