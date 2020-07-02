package com.example.mvvmquote.ui.quote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.mvvmquote.R
import com.example.mvvmquote.data.Quote
import com.example.mvvmquote.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quote.*
import java.lang.StringBuilder

class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote \n\n")
            }

            textView.text = stringBuilder.toString()
        })

        button.setOnClickListener {
            val quote = Quote(et_quote.text.toString(), et_author.text.toString())

            viewModel.addQuote(quote)
            et_quote.setText("")
            et_author.setText("")

        }




    }
}