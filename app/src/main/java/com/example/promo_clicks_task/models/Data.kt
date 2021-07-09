package com.example.promo_clicks_task.models

data class Data(
    val Sliders: List<Slider>,
    val Sponsors: List<Sponsor>,
    val hot_product_paid_status: List<HotProductPaidStatu>,
    val hot_saller_paid_status: List<HotSallerPaidStatu>,
    val recommend_paid_status: List<RecommendPaidStatu>,
    val vendor: List<Vendor>
)