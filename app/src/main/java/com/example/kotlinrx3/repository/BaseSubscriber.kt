package com.example.kotlinrx3.repository


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.kotlinrx3.repository.exception.ApiException
import com.google.gson.JsonSyntaxException
import com.squareup.moshi.*
import io.reactivex.rxjava3.subscribers.DisposableSubscriber
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOError
import java.io.IOException
import java.lang.reflect.Type
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class BaseSubscriber<T>(context: Context) : DisposableSubscriber<T>() {

    private val context: Context = context
    override fun onNext(t: T) {
        if (t is ApiGlobalJson<*>) {
            if (t.rescode == "0") {
                Toast.makeText(context, t.resmsg, Toast.LENGTH_LONG).show()
            } else {
                Log.d("XXoo", "= " + t.toString())
            }
        }
    }

    override fun onError(e: Throwable?) {
        if (e is JsonDataException) {

        }
        when (e) {
            is SocketTimeoutException -> {
                Log.d("XXXYY1", "==")
            }
            is SocketException -> {
                Log.d("XXXYY2", "==")
            }
            is ConnectException -> {
                Log.d("XXXYY3", "==")
            }
            is IOException -> {
                Log.d("XXXYY4", "==")
            }
            is JSONException -> {
                Log.d("XXXYY5", "==")
            }
            is JsonSyntaxException -> {
                Log.d("XXXYY6", "==")
            }
            is UnknownHostException -> {
                Log.d("XXXYY7", "==")
            }
        }

    }

    override fun onComplete() {
        cancel()
    }

    fun read(reader: JsonReader) {

    }
}


