package com.example.handon1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val books: List<String>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
    return BookViewHolder(view)
  }

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    holder.bind(books[position])
  }

  override fun getItemCount(): Int = books.size

  class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val bookNameTextView: TextView = itemView.findViewById(R.id.tv_book_name)

    fun bind(bookName: String) {
      bookNameTextView.text = bookName
    }
  }
}

