package com.example.promo_clicks_task.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promo_clicks_task.Network.RetrofitClientServices
import com.example.promo_clicks_task.models.HomeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var listData : MutableLiveData<HomeData> = MutableLiveData()

    fun makeApiCall() {
        val retroApi = RetrofitClientServices.instance
        val call = retroApi.getHomeData()

        call.enqueue(object : Callback<HomeData> {
            override fun onResponse(
                call: Call<HomeData>,
                response: Response<HomeData>
            ) {

                if (response.isSuccessful)
                    listData.postValue(response.body())
                else
                    listData.postValue(null)

            }

            override fun onFailure(call: Call<HomeData>, t: Throwable) {
                t.printStackTrace()
                listData.postValue(null)

            }
        })
    }

}
