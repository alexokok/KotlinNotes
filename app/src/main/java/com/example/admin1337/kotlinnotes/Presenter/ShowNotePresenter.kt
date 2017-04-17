package com.example.admin1337.kotlinnotes.Presenter

import android.os.Bundle
import com.example.admin1337.kotlinnotes.Model.Note
import com.example.admin1337.kotlinnotes.Model.Notes
import com.example.admin1337.kotlinnotes.Presenter.Interfaces.NotePresenter
import com.example.admin1337.kotlinnotes.Views.Interfaces.INoteView

/**
 * Presenter для вывода заметки
 */
class ShowNotePresenter(override var noteView: INoteView) : NotePresenter {

    lateinit var oldNote:Note

    override fun loadNote() {
        var bundle: Bundle = noteView.getIntent().extras

        var n: Note = bundle.get("VIEW_NOTE") as Note

        oldNote = n.copy()

        noteView.setNoteTitle(n.title)

        noteView.setDescription(n.description)
    }

    override fun saveNote() {

        var newNote:Note = Note(noteView.getNoteTitle(), noteView.getDescription())

        if(!oldNote.equals(newNote)){
            var notes = Notes.notes
            notes.remove(oldNote)
            notes.add(newNote)
        }
    }

    override fun cancel():Boolean {
        var newNote:Note = Note(noteView.getNoteTitle(), noteView.getDescription())

        if(newNote.equals(oldNote))
            return true

        return false
    }
}