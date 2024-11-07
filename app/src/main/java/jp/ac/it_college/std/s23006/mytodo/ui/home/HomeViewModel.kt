package jp.ac.it_college.std.s23006.mytodo.ui.home

import androidx.lifecycle.ViewModel
import jp.ac.it_college.std.s23006.mytodo.data.Item
import jp.ac.it_college.std.s23006.mytodo.data.ItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeUiState(val itemList: Flow<List<Item>> = flowOf(listOf()))

class HomeViewModel(itemsRepository: ItemsRepository) : ViewModel() {
    val homeUiState = HomeUiState(itemsRepository.getAllItemsStream())
}
