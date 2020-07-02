package com.example.mvvmquote.ui.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmquote.data.QuoteRepository

class QuotesViewModelFactory (private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}