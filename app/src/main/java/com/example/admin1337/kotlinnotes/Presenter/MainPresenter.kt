package com.example.admin1337.kotlinnotes.Presenter

import com.example.admin1337.kotlinnotes.Model.Note
import com.example.admin1337.kotlinnotes.Model.Notes
import com.example.admin1337.kotlinnotes.Views.IMainView

class MainPresenter(override var view: IMainView):IMainPresenter {

    fun initNotes(): List<Note> {
        var notes = Notes.notes

        notes.add(Note("Первая заметка", "Описание для первой заметки"))
        notes.add(Note("Вторая заметка", "Описание для второй заметки"))

        return notes;
    }

    override fun loadNotes(): List<Note> {
        var notes = Notes.notes

        if(notes.size == 0)
            initNotes()

        return notes;
    }

    override fun addNote(){
        view.addNote()
    }

    override fun deleteNote(note:Note) {
        var notes = Notes.notes
        notes.remove(note)
    }

    override fun showNote(position: Int) {
        var notes = Notes.notes
        view.updateNote(notes.get(position))
    }
}