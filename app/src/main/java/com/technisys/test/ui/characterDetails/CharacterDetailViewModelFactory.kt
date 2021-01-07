package com.technisys.test.ui.characterDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.technisys.test.model.Character

class CharacterDetailViewModelFactory(
    private val character: Character,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterDetailsViewModel::class.java)) {
            return CharacterDetailsViewModel(character, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}