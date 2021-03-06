package com.example.mvvmquote.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.logging.Logger

class FakeQuoteDAO {
    // data access object
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }
//
//    fun getQuotes() {
//        quotes as LiveData<List<Quote>>
//        Logger.getLogger("FakeQuoteDAO").warning("FAKE")
//
//    }
    fun getQuotes() : LiveData<List<Quote>>{
        Logger.getLogger("FakeQuoteDAO").warning("FAKE")
        return quotes as LiveData<List<Quote>>
    }

}