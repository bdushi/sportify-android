package al.bruno.sportify.ui.event.create

import al.bruno.sportify.data.source.NewEventRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewEventViewModel constructor(
    private val newEventRepository: NewEventRepository
): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            newEventRepository.getAllReference()
        }
    }
}