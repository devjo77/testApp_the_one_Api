package com.technisys.test.ui.characterDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.technisys.test.databinding.CharacterDetailsFragmentBinding

class CharacterDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application

        val binding = CharacterDetailsFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val args = CharacterDetailsFragmentArgs.fromBundle(arguments!!).selectedProperty

        val viewModelFactory = CharacterDetailViewModelFactory(args, application)

       binding.viewmodel = ViewModelProvider(this, viewModelFactory).get(CharacterDetailsViewModel::class.java)

        return binding.root

    }

}




