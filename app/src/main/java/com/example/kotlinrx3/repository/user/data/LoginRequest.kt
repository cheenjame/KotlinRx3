package com.example.kotlinrx3.repository.user.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "dev_uuid") val uuid: String,
    @Json(name = "account") val account: String,
    @Json(name = "password") val password: String
)


