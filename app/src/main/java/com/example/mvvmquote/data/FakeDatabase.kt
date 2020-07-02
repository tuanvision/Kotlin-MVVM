package com.example.mvvmquote.data

class FakeDatabase private constructor(){
    // TODO: private constructor
    var quoteDao = FakeQuoteDAO()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
                instance ?: synchronized(lock = this){
                    instance ?: FakeDatabase().also { instance = it }
                }
    }
}