package com.example.mvvmquote.ui.quote

import androidx.lifecycle.ViewModel
import com.example.mvvmquote.data.Quote
import com.example.mvvmquote.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) :ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}