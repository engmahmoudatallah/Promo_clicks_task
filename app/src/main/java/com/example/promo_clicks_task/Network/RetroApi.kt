package com.example.promo_clicks_task.Network

import com.example.promo_clicks_task.models.HomeData
import com.example.promo_clicks_task.models.ProductsData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroApi {

    @GET(Urls.HOME_PAGE)
    fun getHomeData(): Call<HomeData>


    @FormUrlEncoded
    @POST(Urls.PRODUCT_DETAILS)
    fun getProductsData(@Field("product_id") pKey: Int): Call<ProductsData>


}