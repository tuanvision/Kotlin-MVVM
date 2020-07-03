package com.example.mvvmquote.ui.folderlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmquote.models.Folder
import com.example.mvvmquote.repositories.FolderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FolderListViewModel(private val folderRepository: FolderRepository) : ViewModel() {

    val scope = CoroutineScope(context = Dispatchers.IO)


    fun getFolders() = folderRepository.getFolders()

    fun loadFolders(){
        val job = scope.launch {
            folderRepository.loadFolders(pathToFolder ?: Folder.DEFAULT_PATH_FOLDER)
        }
    }

    var pathToFolder : String? = null
        set(value) {
            field = value
            if (value != null){
                 loadFolders()
            }
        }

}