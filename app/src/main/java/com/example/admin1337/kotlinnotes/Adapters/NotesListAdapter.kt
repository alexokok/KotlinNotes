package com.example.admin1337.kotlinnotes.Adapters

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.admin1337.kotlinnotes.Model.Note
import android.view.LayoutInflater
import com.example.admin1337.kotlinnotes.Model.Notes.NoteList.notes
import com.example.admin1337.kotlinnotes.R
import com.example.admin1337.kotlinnotes.Views.Interfaces.IMainView
import kotlinx.android.synthetic.main.item_note.view.*


/**
 * Адаптер для RecyclerView
 */
class NotesListAdapter(var mainView: IMainView, var notes:List<Note>): RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mainView.getContext())
                .inflate(R.layout.item_note, parent, false)

        val vh = ViewHolder(v)

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.setView(mainView)
        holder!!.bindNote(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var mainView: IMainView

        fun setView(view: IMainView){
            mainView = view
        }

        fun bindNote(note:Note){
            itemView.title_text_view.text = note.title
            itemView.title_text_view.setOnClickListener {
                mainView.updateNote(note)
            }

            itemView.description_text_view.text = note.description
            itemView.description_text_view.setOnClickListener {
                mainView.updateNote(note)
            }

            itemView.delete_button.setOnClickListener {
                var dialog:AlertDialog.Builder = AlertDialog.Builder(itemView.context)
                dialog.setTitle(R.string.delete_title)
                      .setMessage(R.string.delete_message)
                      .setNegativeButton(R.string.action_no, DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                      })
                      .setPositiveButton(R.string.action_yes, DialogInterface.OnClickListener { dialog, which ->
                           notes.remove(note)
                           mainView.updateUi()
                           dialog.dismiss()
                      })
                dialog.create().show()
            }
        }
    }
}