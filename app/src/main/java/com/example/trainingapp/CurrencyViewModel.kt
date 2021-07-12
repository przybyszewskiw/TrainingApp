package com.example.trainingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.trainingapp.data.Currency
import com.example.trainingapp.data.CurrencyRepository
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

class CurrencyViewModel (private val currencyRepository: CurrencyRepository) : ViewModel() {
    lateinit var currencies: Observable<List<Currency>>

    init {
        viewModelScope.launch {
            currencies = currencyRepository.getData()
        }
    }
}

@Singleton
class CurrencyViewModelFactory @Inject constructor(private val currencyRepository: CurrencyRepository) :
    ViewModelProvider.Factory {
    override fun <T: ViewModel?> create (modelClass : Class<T>): T {
        return modelClass.getConstructor(CurrencyRepository::class.java)
            .newInstance(currencyRepository)
    }
}