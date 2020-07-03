package com.example.mvvmquote.ui.folderlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmquote.repositories.FolderRepository
import com.example.mvvmquote.ui.quote.QuotesViewModel

class FolderListViewModelFactory(private val folderRepository: FolderRepository)
    : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FolderListViewModel(folderRepository) as T
    }
}