package com.example.quoteapp_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuoteViewModelFactory (private val quotesRepository: QuotesRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quotesRepository) as T
    }
}