package com.example.kotlinrx3.repository.service

import com.example.kotlinrx3.repository.ApiGlobalJson
import com.example.kotlinrx3.repository.user.data.LoginData
import com.example.kotlinrx3.repository.user.data.LoginRequest
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface LoginService {
    @POST("Login")
    @Multipart
    fun login(@Part("datas") login: LoginRequest): Flowable<ApiGlobalJson<LoginData>>

}