package com.example.testtask.data


import com.google.gson.annotations.SerializedName

data class X(
    @SerializedName("contract_address")
    val contractAddress: String,
    @SerializedName("decimal_place")
    val decimalPlace: Any?
)