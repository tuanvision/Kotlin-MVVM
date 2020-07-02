package com.example.mvvmquote.utilities

import com.example.mvvmquote.data.FakeDatabase
import com.example.mvvmquote.data.QuoteRepository
import com.example.mvvmquote.ui.quote.QuotesViewModel
import com.example.mvvmquote.ui.quote.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}