package com.example.admin1337.kotlinnotes.Presenter

import com.example.admin1337.kotlinnotes.Model.Notes
import com.example.admin1337.kotlinnotes.Views.INoteView

/**
 * Presenter для заметки
 */
interface NotePresenter {

    var noteView: INoteView

    fun loadNote()

    fun saveNote()

    fun cancel():Boolean
}