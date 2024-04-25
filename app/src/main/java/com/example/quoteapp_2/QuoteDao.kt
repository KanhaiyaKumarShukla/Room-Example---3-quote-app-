package com.example.quoteapp_2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM Quote")
    fun getQuote():LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}