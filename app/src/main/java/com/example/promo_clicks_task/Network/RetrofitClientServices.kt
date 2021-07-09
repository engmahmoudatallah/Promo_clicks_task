package com.example.promo_clicks_task.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClientServices {
    /********
     * this class is used to initialize global retrofit instance
     */
    /**
     * Get Retrofit Instance
     */

    private fun getRetrofitInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Urls.BASE_LINK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val instance: RetroApi by lazy {
        getRetrofitInstance().create(RetroApi::class.java)
    }

    /**
     * Get API Service
     *
     * @return API Service
     */

}