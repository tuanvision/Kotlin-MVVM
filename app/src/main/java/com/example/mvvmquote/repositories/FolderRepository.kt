package com.example.mvvmquote.repositories

import com.example.mvvmquote.data.FakeQuoteDAO
import com.example.mvvmquote.data.QuoteRepository
import com.example.mvvmquote.models.Folder
import com.example.mvvmquote.models.FolderDAO

class FolderRepository private constructor(private val folderDAO: FolderDAO){

    fun getFolders() = folderDAO.getFolders()

    suspend fun loadFolders(pathToFolder: String){
        folderDAO.loadFolders(pathToFolder)
    }

    companion object {
        @Volatile private var instance: FolderRepository? = null

        fun getInstance(folderDAO: FolderDAO) =
            instance ?: synchronized(lock = this){
                instance ?: FolderRepository(folderDAO).also { instance = it }
            }
    }
}