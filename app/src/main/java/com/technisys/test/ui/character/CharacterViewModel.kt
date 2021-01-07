package com.technisys.test.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technisys.test.network.OneApi
import kotlinx.coroutines.launch
import com.technisys.test.model.Character
import com.technisys.test.network.ApiStatusEnum

class CharacterViewModel() : ViewModel() {

    //  the status of the most recent request
    private val _status = MutableLiveData<ApiStatusEnum>()

    val status: LiveData<ApiStatusEnum>
        get() = _status

    // The external immutable LiveData for the request status
    val statusEnum: LiveData<ApiStatusEnum>
        get() = _status

    // MutableLiveData, update the List with new values
    private val _character = MutableLiveData<List<Character>>()

    val character: LiveData<List<Character>>
        get() = _character

    // LiveData to handle navigation
    private val _navigateToSelectedProperty = MutableLiveData<Character>()

    val navigateToSelectedProperty: LiveData<Character>
        get() = _navigateToSelectedProperty


    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {

            _status.value = ApiStatusEnum.LOADING

            try {
                _character.value = OneApi.retrofitService.getCharacterByPage().items
                _status.value = ApiStatusEnum.DONE
            } catch (e: Exception) {
                _status.value = ApiStatusEnum.ERROR
                _character.value = ArrayList()
            }
        }
    }


    fun displayCharacteryDetails(character: Character) {
        _navigateToSelectedProperty.value = character
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    fun updateFilter() {
        getCharacters()
    }


}