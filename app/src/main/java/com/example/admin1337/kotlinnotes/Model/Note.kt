package com.example.admin1337.kotlinnotes.Model

import java.io.Serializable

/** класс с заметкой */
data class Note(var title:String, var description:String):Cloneable, Serializable