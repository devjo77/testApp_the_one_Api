package com.technisys.test.ui.characterDetails

import android.app.Application
import androidx.lifecycle.*
import com.technisys.test.model.Character

class CharacterDetailsViewModel(character: Character, app: Application) : AndroidViewModel(app) {

    private val _character = MutableLiveData<Character>()

    val character: LiveData<Character>
        get() = _character

    init {
        _character.value = character
    }
}

