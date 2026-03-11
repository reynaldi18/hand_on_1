package com.example.handon1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  private val books = mutableListOf<String>()
  private lateinit var bookAdapter: BookAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    val inputBook = findViewById<EditText>(R.id.et_book)
    val addButton = findViewById<Button>(R.id.btn_add)
    val bookRecyclerView = findViewById<RecyclerView>(R.id.rv_book)

    bookAdapter = BookAdapter(books)
    bookRecyclerView.layoutManager = LinearLayoutManager(this)
    bookRecyclerView.adapter = bookAdapter

    addButton.setOnClickListener {
      val bookName = inputBook.text.toString().trim()
      if (bookName.isEmpty()) {
        inputBook.error = "Input cannot be empty"
        return@setOnClickListener
      }

      books.add(bookName)
      bookAdapter.notifyItemInserted(books.lastIndex)
      inputBook.text.clear()
      inputBook.clearFocus()
    }
  }
}