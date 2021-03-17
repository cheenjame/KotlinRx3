package com.example.kotlinrx3.repository.user.data

import com.example.kotlinrx3.repository.user.adapter.ResCodeSting
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginData(
    @Json(name = "api_area") val area: String,
    @Json(name = "new_account") val account: Boolean,
    val token: String
)

