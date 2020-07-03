package com.example.mvvmquote.models

import com.example.mvvmquote.data.FakeDatabase

class FolderDatabase private constructor(){
    var folderDAO = FolderDAO()
        private set


    companion object {
        @Volatile private var instance: FolderDatabase? = null

        fun getInstance() =
            instance ?: synchronized(lock = this){
                instance ?: FolderDatabase().also { instance = it }
            }
    }
}