package com.fransiscuscaesar.skybridge.data.models

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("id")
    val id: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("overview")
    val overview: String?
)