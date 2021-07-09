package com.example.promo_clicks_task.models

data class HotProductPaidStatu(
    val ProductUserNumber: Int,
    val exp_date: String,
    val id: Int,
    val image: String,
    val name: String,
    val new_price: Int,
    val old_price: Int,
    val rate: Float
)