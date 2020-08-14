package com.fransiscuscaesar.skybridge.data.models

import com.google.gson.annotations.SerializedName

data class NetworkResponse (
    @SerializedName("results")
    val result: List<Movie>?
)