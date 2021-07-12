package com.example.trainingapp.webservice

import com.example.trainingapp.data.Table
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Webservice {
    @GET("api/exchangerates/tables/A?format=json")
    fun getListElements(): Observable<List<Table>>
}