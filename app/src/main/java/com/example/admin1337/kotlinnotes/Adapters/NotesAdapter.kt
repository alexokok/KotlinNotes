package com.example.admin1337.kotlinnotes.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.admin1337.kotlinnotes.Model.Note
import com.example.admin1337.kotlinnotes.R

/**
 * Адаптер для заметок
 */
class NotesAdapter(var notesList:List<Note>, var context: Context): BaseAdapter() {

    val ADAPTER_TAG:String = "NotesAdapter"

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view:View? = convertView

        if(convertView == null){
            Log.d(ADAPTER_TAG, "зашёл в адаптер")

            var inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            Log.d(ADAPTER_TAG, "создал inflater")

            view = inflater.inflate(R.layout.item_note, null)
        }

        var  title: TextView = view!!.findViewById(R.id.title_text_view) as TextView
        title.text = notesList[position].title

        var description: TextView = view!!.findViewById(R.id.description_text_view) as TextView
        description.text = notesList[position].description

        return view
    }

    override fun getItem(position: Int): Any {
        return notesList[position]
    }

    override fun getItemId(position: Int): Long {
        return 111111
    }

    override fun getCount(): Int {
        return notesList.size
    }
}