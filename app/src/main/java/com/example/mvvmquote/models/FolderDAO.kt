package com.example.mvvmquote.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.logging.Logger

class FolderDAO {

    // data access object
    private var folderList = mutableListOf<Folder>()
    private val folders = MutableLiveData<List<Folder>>()

    init {
        folders.value = folderList
    }

    fun getFolders() = folders as LiveData<List<Folder>>

    suspend fun loadFolders(path_folder: String=""){

        folderList = mutableListOf<Folder>()
        val file = File(path_folder)
        for (i in 1..10000){
            if (file.isDirectory){
                file.listFiles().forEach {fileInFolder ->

                    val path = fileInFolder.absolutePath

                    if (!path.contains(".json")){
                        folderList.add(Folder(path))
                    }
                }
            }
        }

        folders.value = folderList

    }

}