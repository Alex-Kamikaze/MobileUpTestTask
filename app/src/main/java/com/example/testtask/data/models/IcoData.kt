package com.example.testtask.data.models


import com.google.gson.annotations.SerializedName

data class IcoData(
    @SerializedName("accepting_currencies")
    val acceptingCurrencies: String,
    @SerializedName("amount_for_sale")
    val amountForSale: Any?,
    @SerializedName("base_pre_sale_amount")
    val basePreSaleAmount: Any?,
    @SerializedName("base_public_sale_amount")
    val basePublicSaleAmount: Int,
    @SerializedName("bounty_detail_url")
    val bountyDetailUrl: String,
    @SerializedName("country_origin")
    val countryOrigin: String,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("hardcap_amount")
    val hardcapAmount: Any?,
    @SerializedName("hardcap_currency")
    val hardcapCurrency: String,
    @SerializedName("ico_end_date")
    val icoEndDate: Any?,
    @SerializedName("ico_start_date")
    val icoStartDate: Any?,
    @SerializedName("kyc_required")
    val kycRequired: Boolean,
    @SerializedName("links")
    val links: Links,
    @SerializedName("pre_sale_available")
    val preSaleAvailable: Any?,
    @SerializedName("pre_sale_end_date")
    val preSaleEndDate: Any?,
    @SerializedName("pre_sale_ended")
    val preSaleEnded: Boolean,
    @SerializedName("pre_sale_start_date")
    val preSaleStartDate: Any?,
    @SerializedName("quote_pre_sale_amount")
    val quotePreSaleAmount: Any?,
    @SerializedName("quote_pre_sale_currency")
    val quotePreSaleCurrency: String,
    @SerializedName("quote_public_sale_amount")
    val quotePublicSaleAmount: Double,
    @SerializedName("quote_public_sale_currency")
    val quotePublicSaleCurrency: String,
    @SerializedName("short_desc")
    val shortDesc: String,
    @SerializedName("softcap_amount")
    val softcapAmount: Any?,
    @SerializedName("softcap_currency")
    val softcapCurrency: String,
    @SerializedName("total_raised")
    val totalRaised: Any?,
    @SerializedName("total_raised_currency")
    val totalRaisedCurrency: String,
    @SerializedName("whitelist_available")
    val whitelistAvailable: Boolean,
    @SerializedName("whitelist_end_date")
    val whitelistEndDate: Any?,
    @SerializedName("whitelist_start_date")
    val whitelistStartDate: Any?,
    @SerializedName("whitelist_url")
    val whitelistUrl: String
)