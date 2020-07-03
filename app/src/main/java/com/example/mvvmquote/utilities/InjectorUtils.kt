package com.example.mvvmquote.utilities

import com.example.mvvmquote.data.FakeDatabase
import com.example.mvvmquote.data.QuoteRepository
import com.example.mvvmquote.models.FolderDatabase
import com.example.mvvmquote.repositories.FolderRepository
import com.example.mvvmquote.ui.folderlist.FolderListViewModelFactory
import com.example.mvvmquote.ui.quote.QuotesViewModel
import com.example.mvvmquote.ui.quote.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

    fun provideFolderListViewModelFactory(): FolderListViewModelFactory {
        val folderListRepository = FolderRepository.getInstance(FolderDatabase.getInstance().folderDAO)
        return FolderListViewModelFactory(folderListRepository)
    }

}