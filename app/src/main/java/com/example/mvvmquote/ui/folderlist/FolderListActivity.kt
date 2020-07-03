package com.example.mvvmquote.ui.folderlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmquote.R
import com.example.mvvmquote.adapters.FolderListAdapter
import com.example.mvvmquote.iface.OnItemClickListener
import com.example.mvvmquote.models.Folder
import com.example.mvvmquote.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_folder_list.*
import java.util.logging.Logger

class FolderListActivity : AppCompatActivity(), OnItemClickListener {

    var folderListAdapter: FolderListAdapter = FolderListAdapter(arrayListOf(), this)
    lateinit var factory: FolderListViewModelFactory
    lateinit var viewModel: FolderListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folder_list)

        initializeUi()

        initIntent()
    }


    private fun initializeUi() {
        factory = InjectorUtils.provideFolderListViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(FolderListViewModel::class.java)

        folderlist_recycleview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = folderListAdapter
            setHasFixedSize(true)
        }


        viewModel.getFolders().observe(this, Observer { folders ->

            folderListAdapter.folders = folders
            folderListAdapter.notifyDataSetChanged()

        })
    }


    private fun initIntent(){

        if (viewModel.pathToFolder == null){
            viewModel.pathToFolder = Folder.DEFAULT_PATH_FOLDER
        }
    }


    override fun onItemClick(fileName: String, position: Int) {
    }

    override fun onLongClickListener(fileName: String, position: Int): Boolean {
        return true
    }
}