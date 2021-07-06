package com.example.promo_clicks_task.Network

import com.example.promo_clicks_task.Model.retrofitModels.Slider
import com.example.promo_clicks_task.Model.retrofitModels.SlidersModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroApi {

    @GET(Urls.HOME_PAGE)
    fun getHomeData(): Call<SlidersModel>


    @FormUrlEncoded
    @POST(Urls.PRODUCT_DETAILS)
    fun getProductsData(@Field(Urls.PRODUCT_KEY) pKey: String): Call<Slider>


}