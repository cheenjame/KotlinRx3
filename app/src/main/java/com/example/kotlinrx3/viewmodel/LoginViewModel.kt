package com.example.kotlinrx3.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.kotlinrx3.repository.ApiGlobalJson
import com.example.kotlinrx3.repository.ApiRepository
import com.example.kotlinrx3.repository.BaseSubscriber
import com.example.kotlinrx3.repository.user.data.LoginData
import com.example.kotlinrx3.repository.user.data.LoginRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subscribers.DisposableSubscriber


class LoginViewModel : ViewModel() {
    fun login(account: String, password: String, deviceId: String, context: Context) {
        val loginMap = LoginRequest(uuid = deviceId, account = account, password = password)
        ApiRepository.loginSerVice.login(loginMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : BaseSubscriber<ApiGlobalJson<LoginData>>(context) {
                override fun onNext(t: ApiGlobalJson<LoginData>) {
                    val loginData: LoginData? = t.resdata
                    Toast.makeText(context, t.resmsg, Toast.LENGTH_LONG).show()
                }

                override fun onError(t: Throwable?) {
                    super.onError(t)
                    Toast.makeText(context, "錯誤", Toast.LENGTH_LONG).show()
                }

                override fun onComplete() {
                }
            })
        ApiRepository.loginSerVice.login(loginMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
