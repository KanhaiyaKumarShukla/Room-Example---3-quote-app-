package com.example.quoteapp_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel (private val quoteRepo: QuotesRepository):ViewModel(){
    fun getQuotes() : LiveData<List<Quote>>{
        return quoteRepo.getQuotes()
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.insertQuotes(quote)
        }
    }
}