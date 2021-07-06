package com.example.promo_clicks_task.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promo_clicks_task.Model.retrofitModels.Slider

class SimpleModel : ViewModel() {

    val list = MutableLiveData<Slider>()
    init {
        list.value = Slider(1,"https://i.pinimg.com/originals/44/55/02/4455028aaab647b070b33b3a29a5f95e.jpg","simple text",1,"simple test text")
    }


/*    fun getSlidersData() {

        var retroApi = RetrofitClientServices.instance
        var modelCallback: Call<List<SliderList>> = retroApi.getHomeData()

        modelCallback.enqueue(object : Callback<List<SliderList>> {
            override fun onResponse(
                call: Call<List<SliderList>>,
                response: Response<List<SliderList>>
            ) {

                if (response.isSuccessful)
                    list.postValue(response.body())
                else
                    list.postValue(null)
            }

            override fun onFailure(call: Call<List<SliderList>>, t: Throwable) {
                t.printStackTrace()

            }
        })
    }*/
}
