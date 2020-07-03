package com.example.mvvmquote.models

import android.graphics.Bitmap
import android.os.Environment

@Suppress("DEPRECATION")
class Folder {

    var path_folder: String = DEFAULT_PATH_FOLDER
    var bitmap_folder: Bitmap? = null

    companion object {
        val DEFAULT_PATH_FOLDER: String = Environment.getExternalStorageDirectory().absolutePath + "/Download"

    }

    constructor(path_folder: String, bitmap_folder: Bitmap) {
        this.path_folder = path_folder
        this.bitmap_folder = bitmap_folder
    }
    constructor(path_folder: String){
        this.path_folder = path_folder
    }

}