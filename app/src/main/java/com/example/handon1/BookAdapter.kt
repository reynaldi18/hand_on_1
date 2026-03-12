package com.example.handon1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val books: MutableList<String>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
    return BookViewHolder(view)
  }

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    holder.bind(books[position]) { itemPosition ->
      removeBook(itemPosition)
    }
  }

  override fun getItemCount(): Int = books.size

  private fun removeBook(position: Int) {
    if (position !in books.indices) return
    books.removeAt(position)
    notifyItemRemoved(position)
  }

  class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val bookNameTextView: TextView = itemView.findViewById(R.id.tv_book_name)
    private val deleteButton: Button = itemView.findViewById(R.id.btn_delete)

    fun bind(bookName: String, onDeleteClick: (Int) -> Unit) {
      bookNameTextView.text = bookName
      deleteButton.setOnClickListener {
        val position = bindingAdapterPosition
        if (position != RecyclerView.NO_POSITION) {
          onDeleteClick(position)
        }
      }
    }
  }
}
