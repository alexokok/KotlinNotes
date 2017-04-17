package com.example.admin1337.kotlinnotes.Views

import android.content.Intent

/**
 * представление для заметки
 */
interface INoteView {

    fun getNoteTitle():String

    fun setNoteTitle(title:String)

    fun getDescription():String

    fun setDescription(title:String)

    fun getIntent():Intent
}