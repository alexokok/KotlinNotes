package com.example.admin1337.kotlinnotes.Model

class Notes private constructor(){
    companion object NoteList{
        var notes : ArrayList<Note> = ArrayList<Note>()
    }
}