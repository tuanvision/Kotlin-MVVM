package com.example.mvvmquote.iface

interface OnItemClickListener {
    fun onItemClick(fileName: String, position: Int)
    fun onLongClickListener(fileName: String, position: Int): Boolean
}

