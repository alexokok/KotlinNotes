package com.example.admin1337.kotlinnotes.Views

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.admin1337.kotlinnotes.Adapters.NotesAdapter
import com.example.admin1337.kotlinnotes.Adapters.NotesListAdapter
import com.example.admin1337.kotlinnotes.Model.Note
import com.example.admin1337.kotlinnotes.Presenter.Interfaces.IMainPresenter
import com.example.admin1337.kotlinnotes.Presenter.MainPresenter

import com.example.admin1337.kotlinnotes.R
import com.example.admin1337.kotlinnotes.Views.Interfaces.IMainView

class MainView : AppCompatActivity(), IMainView {

    val activityTag: String = "MainView";

    val ADD_OPERATION: Int = 1

    val SHOW_OPERATION: Int = 2

    lateinit var recyclerView: RecyclerView

    lateinit var toolBar: Toolbar

    lateinit var presenterI: IMainPresenter

    lateinit var notesAdapter: NotesListAdapter

    override fun updateUi() {
        notesAdapter.notes = presenterI.loadNotes()
        notesAdapter.notifyDataSetChanged()
    }

    override fun addNote(){
        var intent:Intent = Intent(this, AddNoteView::class.java)
        startActivityForResult(intent, ADD_OPERATION)
    }

    override fun getContext(): Context {
        return this
    }

    override fun updateNote(note: Note) {
        var intent:Intent = Intent(this, ShowNoteView::class.java)

        intent.putExtra("VIEW_NOTE", note)

        startActivityForResult(intent, SHOW_OPERATION)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterI = MainPresenter(this)

        toolBar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)

        Log.d(activityTag, "достал вьюшку для активности")

        recyclerView = findViewById(R.id.notes_recycler) as RecyclerView
        recyclerView.setHasFixedSize(true)

        var layoutManager:LinearLayoutManager = LinearLayoutManager(this)

        recyclerView.setLayoutManager(layoutManager)

        notesAdapter = NotesListAdapter(this, presenterI.loadNotes())
        recyclerView.setAdapter(notesAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId){
            R.id.action_add_note -> {
                presenterI.addNote()
            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode){
            ADD_OPERATION ->{
                if(requestCode.equals(Activity.RESULT_OK))
                    updateUi()
            }
        }
    }
}
