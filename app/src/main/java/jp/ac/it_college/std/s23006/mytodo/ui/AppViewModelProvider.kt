package jp.ac.it_college.std.s23006.mytodo.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import jp.ac.it_college.std.s23006.mytodo.TodoApplication
import jp.ac.it_college.std.s23006.mytodo.ui.home.HomeViewModel
import jp.ac.it_college.std.s23006.mytodo.ui.item.ItemEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(todoApplication().container.itemsRepository)
        }
        initializer {
            ItemEntryViewModel(todoApplication().container.itemsRepository)
        }
    }
}

fun CreationExtras.todoApplication(): TodoApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
            as TodoApplication)