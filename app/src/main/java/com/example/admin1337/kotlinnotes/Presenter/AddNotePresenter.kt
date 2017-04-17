package com.example.admin1337.kotlinnotes.Presenter

import com.example.admin1337.kotlinnotes.Model.Note
import com.example.admin1337.kotlinnotes.Model.Notes
import com.example.admin1337.kotlinnotes.Presenter.Interfaces.NotePresenter
import com.example.admin1337.kotlinnotes.Views.Interfaces.INoteView

/**
 * Presenter для добавления заметки
 */
class AddNotePresenter(override var noteView: INoteView) : NotePresenter {

    override fun loadNote() {

    }

    override fun saveNote() {
        var notes = Notes.notes

        notes.add(Note(noteView.getNoteTitle(), noteView.getDescription()))
    }

    override fun cancel(): Boolean {
        if(noteView.getDescription().isEmpty() && noteView.getNoteTitle().isEmpty())
            return true

        return false
    }

}