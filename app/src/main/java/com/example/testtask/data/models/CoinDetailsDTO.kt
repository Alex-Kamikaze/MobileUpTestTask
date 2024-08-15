package com.example.testtask.data.models


import com.google.gson.annotations.SerializedName

data class CoinDetailsDTO(
    @SerializedName("additional_notices")
    val additionalNotices: List<Any>,
    @SerializedName("asset_platform_id")
    val assetPlatformId: Any?,
    @SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Int,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("country_origin")
    val countryOrigin: String,
    @SerializedName("description")
    val description: Description,
    @SerializedName("detail_platforms")
    val detailPlatforms: DetailPlatforms,
    @SerializedName("genesis_date")
    val genesisDate: Any?,
    @SerializedName("hashing_algorithm")
    val hashingAlgorithm: Any?,
    @SerializedName("ico_data")
    val icoData: IcoData,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("platforms")
    val platforms: Platforms,
    @SerializedName("preview_listing")
    val previewListing: Boolean,
    @SerializedName("public_notice")
    val publicNotice: Any?,
    @SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double,
    @SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double,
    @SerializedName("status_updates")
    val statusUpdates: List<Any>,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("watchlist_portfolio_users")
    val watchlistPortfolioUsers: Int,
    @SerializedName("web_slug")
    val webSlug: String
)