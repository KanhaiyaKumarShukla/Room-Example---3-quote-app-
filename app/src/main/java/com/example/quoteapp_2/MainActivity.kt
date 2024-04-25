package com.example.quoteapp_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapp_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao=QuoteDatabase.getInstance(applicationContext).quoteDao()
        quoteViewModel= ViewModelProvider(this, QuoteViewModelFactory(QuotesRepository(dao)))[QuoteViewModel::class.java]

        quoteViewModel.getQuotes().observe( this) {
            binding.quotes = it.toString()
        }
        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0, "This is testing", "Testing")
            quoteViewModel.insertQuote(quote)
        }
    }
}