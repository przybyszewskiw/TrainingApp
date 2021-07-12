package com.example.trainingapp.data

import com.example.trainingapp.webservice.Webservice
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyRepository @Inject constructor(private val webservice: Webservice,
                                             private val currencyDao: CurrencyDao
) {

    fun getData(): Observable<List<Currency>> {
        // Can we do better than hardcode this timeout?
        currencyDao.isEmpty()
            .timeout(1, TimeUnit.SECONDS)
            .onErrorResumeNext { Single.just(listOf()) }
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe {newData ->
                if(newData.isEmpty()){
                    refreshData()
                }
            }

        return currencyDao.load()
    }

    private fun refreshData() {
        webservice.getListElements()
            .map { x -> x.elementAt(0).rates }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe{newData ->
                for (d in newData) {
                    currencyDao.save(d)
                }
            }
    }
}