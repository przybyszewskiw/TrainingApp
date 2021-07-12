package com.example.trainingapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface CurrencyDao {
    @Insert(onConflict = REPLACE)
    fun save(currency: Currency)

    @Query("SELECT * FROM currency")
    fun load(): Observable<List<Currency>>

    @Query("SELECT * FROM currency")
    fun isEmpty(): Single<List<Currency>>
}