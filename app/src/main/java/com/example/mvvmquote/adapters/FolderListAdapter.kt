package com.example.mvvmquote.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmquote.R
import com.example.mvvmquote.iface.OnItemClickListener
import com.example.mvvmquote.models.Folder

class FolderListAdapter(var folders: List<Folder>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<FolderItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.folder_list_item, parent, false)
        return FolderItemViewHolder(view, onItemClickListener)

    }

    override fun getItemCount(): Int {
        return folders.size
    }

    override fun onBindViewHolder(holder: FolderItemViewHolder, position: Int) {
        holder.bind(folders[position], position, false)
    }
}

@Suppress("DEPRECATION")
class FolderItemViewHolder(private val view: View,
                           private val onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

    fun bind(pathFile: Folder, position: Int, isCurrent: Boolean){

        view.setBackgroundColor(if (isCurrent) view.context.resources.getColor(R.color.app_blue_dark) else view.context.resources.getColor(R.color.colorBackground))
        view.findViewById<TextView>(R.id.tv_folder_name).text =  basename(pathFile.path_folder) // if (compact) basename(fileName) else fileName

//        view.setBackgroundColor(view.context.resources.getColor())

        view.setOnClickListener {
//            if (clickable)
                onItemClickListener.onItemClick(pathFile.path_folder, position)
        }
        view.setOnLongClickListener {
//            if (clickable)
                onItemClickListener.onLongClickListener(pathFile.path_folder, position)
//            else
//                true
        }

//        isAnnotate(pathFile = pathFile)
//        getBitmap(pathFile)

    }
    private fun basename(fileName: String?): String {
        val pos = fileName?.lastIndexOf("/") ?: -1
        return fileName?.substring(pos+1) ?: ""
    }

}
