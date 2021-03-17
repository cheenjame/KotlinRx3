package com.example.kotlinrx3.repository

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiGlobalJson<T>(
    val resdata: T,
    val rescode: String,
    val resmsg: String,
    val retcode: String,
)
