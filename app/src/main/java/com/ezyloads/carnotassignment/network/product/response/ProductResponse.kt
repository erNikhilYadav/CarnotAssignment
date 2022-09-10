package com.ezyloads.carnotassignment.network.product.response


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("field")
    val `field`: List<Field>,
    @SerializedName("records")
    val records: List<Record>,
) {
    data class Field(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("type")
        val type: String
    )

    data class Record(
        @SerializedName("arrival_date")
        val arrivalDate: String,
        @SerializedName("commodity")
        val commodity: String,
        @SerializedName("district")
        val district: String,
        @SerializedName("market")
        val market: String,
        @SerializedName("max_price")
        val maxPrice: String,
        @SerializedName("min_price")
        val minPrice: String,
        @SerializedName("modal_price")
        val modalPrice: String,
        @SerializedName("state")
        val state: String,
        @SerializedName("variety")
        val variety: String
    )

}