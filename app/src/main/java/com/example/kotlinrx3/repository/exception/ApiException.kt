package com.example.kotlinrx3.repository.exception

class ApiException(val errorCode: String) : Exception(errorCode) {
}