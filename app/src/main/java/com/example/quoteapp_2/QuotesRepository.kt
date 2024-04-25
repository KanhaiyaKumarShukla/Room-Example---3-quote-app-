package com.example.quoteapp_2

import androidx.lifecycle.LiveData

class QuotesRepository (private val quoteDao:QuoteDao){
    fun getQuotes():LiveData<List<Quote>> {
        return quoteDao.getQuote()
    }
    suspend fun insertQuotes(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}