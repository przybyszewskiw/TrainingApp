package com.example.trainingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Table(
    val table: String,
    val no: String,
    val effectiveDate: String,
    val rates: List<Currency>
)

@Entity
data class Currency(
    val currency: String,
    @PrimaryKey val code: String,
    val mid: Float
) {
    override fun toString(): String {
        return "$currency ($code) -> $mid"
    }
}