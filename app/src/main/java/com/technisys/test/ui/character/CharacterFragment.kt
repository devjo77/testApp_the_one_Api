package com.technisys.test.ui.character

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.technisys.test.databinding.CharacterFragmentBinding
import com.technisys.test.network.ApiStatusEnum

class CharacterFragment : Fragment() {

    /*** Lazily initialize our [CharacterViewModel].*/

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(
            CharacterViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = CharacterFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.list.adapter = CharacterAdapter(CharacterAdapter.OnClickListener {
            viewModel.displayCharacteryDetails(it)
        })


        binding.swiperefresh.isRefreshing = false

        viewModel.status.observe(this, Observer {
            if (null != it && (it == ApiStatusEnum.DONE || it == ApiStatusEnum.ERROR)) {
                binding.swiperefresh.isRefreshing = false
            }
        })


        viewModel.navigateToSelectedProperty.observe(this, Observer {
            if (null != it) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(CharacterFragmentDirections.actionShowDetail(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayPropertyDetailsComplete()
            }
        })

        binding.swiperefresh.setOnRefreshListener {
            viewModel.updateFilter()
        }

        return binding.root
    }

}