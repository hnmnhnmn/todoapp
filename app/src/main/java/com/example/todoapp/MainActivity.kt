package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTile = edTodoTitle.text.toString()
            if(todoTile.isNotEmpty()) {
                val todo = Todo(todoTile)
                todoAdapter.addTodo(todo)
                edTodoTitle.text.clear()
            }
        }
        btnDeleteTodo.setOnClickListener {
            todoAdapter.deleteTodo()
        }
    }
}