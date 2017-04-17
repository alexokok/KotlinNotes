package com.example.admin1337.kotlinnotes.Views

import android.content.Context
import com.example.admin1337.kotlinnotes.Model.Note


interface IMainView {

    fun addNote()

    fun updateNote(note: Note)

    fun updateUi()

    fun getContext(): Context
}