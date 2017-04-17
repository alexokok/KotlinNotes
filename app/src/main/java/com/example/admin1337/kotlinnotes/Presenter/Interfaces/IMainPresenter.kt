package com.example.admin1337.kotlinnotes.Presenter.Interfaces

import com.example.admin1337.kotlinnotes.Model.Note
import com.example.admin1337.kotlinnotes.Views.Interfaces.IMainView

/**
 * Presenter для главной Activity
 */
interface IMainPresenter {

    var view: IMainView

    fun loadNotes():List<Note>

    fun addNote();

    fun deleteNote(note: Note)

    fun showNote(position: Int)
}