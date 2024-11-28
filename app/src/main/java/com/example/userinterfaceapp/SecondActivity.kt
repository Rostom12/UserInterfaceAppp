package com.example.userinterfaceapp

import BookAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    data class Book(val title: String, val author: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val recyclerView: RecyclerView = findViewById(R.id.main)
    val bookList = listOf(
        Book("Le Petit Prince", "Antoine de Saint-Exupéry"),
        Book("1984", "George Orwell"),
        Book("Harry Potter", "J.K. Rowling")
    )
    recyclerView.layoutManager = LinearLayoutManager(this) // LinearLayoutManager organise les éléments de la liste dans une disposition verticale par défaut.
    recyclerView.adapter = BookAdapter(bookList)
    }
}