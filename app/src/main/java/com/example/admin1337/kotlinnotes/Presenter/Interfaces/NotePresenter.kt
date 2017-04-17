package com.example.admin1337.kotlinnotes.Presenter.Interfaces

import com.example.admin1337.kotlinnotes.Model.Notes
import com.example.admin1337.kotlinnotes.Views.Interfaces.INoteView

/**
 * Presenter для заметки
 */
interface NotePresenter {

    var noteView: INoteView

    fun loadNote()

    fun saveNote()

    fun cancel():Boolean
}