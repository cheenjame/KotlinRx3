package com.example.kotlinrx3.repository.user.adapter

import com.example.kotlinrx3.repository.ApiGlobalJson
import com.example.kotlinrx3.repository.user.data.LoginData
import com.squareup.moshi.*
import java.io.IOException
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@Retention(RUNTIME)
@JsonQualifier
internal annotation class ResCodeSting

class ErrorAdapter {
    @ResCodeSting
    @FromJson
    fun forJson(value: String): String {
        return value
    }


    @ToJson
    fun toJson(@ResCodeSting value: String):  String {
        return value
    }
}


