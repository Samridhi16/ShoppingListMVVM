package com.projects.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.projects.shoppinglist.data.repositories.ShoppingRepository

class ShoppingViewModelFactory (
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}