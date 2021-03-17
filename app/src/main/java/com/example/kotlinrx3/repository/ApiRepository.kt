package com.example.kotlinrx3.repository


import android.util.Log
import com.example.kotlinrx3.BuildConfig
import com.example.kotlinrx3.repository.service.LoginService
import com.example.kotlinrx3.repository.user.adapter.ErrorAdapter
import com.example.kotlinrx3.repository.user.data.LoginData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

private const val BASE_URL = "網址"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private fun getLogInterceptor(): Interceptor {
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return interceptor
}

val builder = OkHttpClient.Builder()
    .addInterceptor(getLogInterceptor())
    .readTimeout(10, TimeUnit.SECONDS)
    .connectTimeout(10, TimeUnit.SECONDS)

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .baseUrl(BASE_URL)
    .client(builder.build())
    .build()

object ApiRepository {
    val loginSerVice: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }
}
