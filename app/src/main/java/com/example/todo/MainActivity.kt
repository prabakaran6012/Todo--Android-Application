package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoadapter : todoadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoadapter= todoadapter(mutableListOf())
        rvtodoitems.adapter=todoadapter
        rvtodoitems.layoutManager=LinearLayoutManager(this)
        btnaddtodo.setOnClickListener {
            val z=ettodolist.text.toString()
            if(z.isNotEmpty()){
                val todo= todo(z)
                todoadapter.addtodo(todo)
                ettodolist.text.clear()
            }
        }
        buttondel.setOnClickListener {
            todoadapter.deletedone()
        }

    }
}