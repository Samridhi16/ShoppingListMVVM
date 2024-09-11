package com.projects.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.projects.shoppinglist.data.db.ShoppingDatabase
import com.projects.shoppinglist.data.repositories.ShoppingRepository

import com.projects.shoppinglist.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory)[ShoppingViewModel::class.java]


    }
}