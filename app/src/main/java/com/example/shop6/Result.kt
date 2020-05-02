package com.example.shop6

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("products")
    var products: List<Product> = listOf()
)