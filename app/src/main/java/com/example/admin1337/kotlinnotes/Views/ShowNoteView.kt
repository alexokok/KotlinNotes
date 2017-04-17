package com.example.admin1337.kotlinnotes.Views

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

import com.example.admin1337.kotlinnotes.Presenter.NotePresenter
import com.example.admin1337.kotlinnotes.Presenter.ShowNotePresenter
import com.example.admin1337.kotlinnotes.R

/**
 * view для просмотра заметки
 */
class ShowNoteView() :AppCompatActivity(), INoteView{

    lateinit var title: EditText;

    lateinit var description: EditText;

    lateinit var save: Button;

    lateinit var cancel: Button;

    lateinit var presenter: NotePresenter

    override fun getNoteTitle(): String {
        return title.text.toString()
    }

    override fun setNoteTitle(noteTitle: String) {
        title.setText(noteTitle)
    }

    override fun getDescription(): String {
        return description.text.toString()
    }

    override fun setDescription(noteDescription: String) {
        description.setText(noteDescription)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)


        presenter = ShowNotePresenter(this);

        title = findViewById(R.id.title_edit_text) as EditText

        description = findViewById(R.id.description_edit_text) as EditText

        save = findViewById(R.id.save_button) as Button
        save.setOnClickListener {
            presenter.saveNote()
            this.finish()
        }

        cancel = findViewById(R.id.cancel_button) as Button
        cancel.setOnClickListener {
            if (presenter.cancel())
                this.finish()
            else {
                var dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)

                dialogBuilder.setTitle(R.string.exit_title)
                        .setMessage(R.string.exit_message)
                        .setNegativeButton(R.string.action_no
                                , DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                        })
                        .setPositiveButton(R.string.action_yes, DialogInterface.OnClickListener { dialog, which ->
                            this.finish()
                        })
                dialogBuilder.create().show()
            }

        }

        presenter.loadNote()
    }
}