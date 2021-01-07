package com.technisys.test.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technisys.test.databinding.CharacterViewItemBinding
import com.technisys.test.model.Character


class CharacterAdapter(private val onClickListener: OnClickListener) :

    ListAdapter<Character, CharacterAdapter.CharacterViewHolder>(DiffCallback) {

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Character]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * The ViewHolder constructor takes the binding variable from the associated
     */
    class CharacterViewHolder(private var binding: CharacterViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.character = character
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(CharacterViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.bind(item)
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Character]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [Character]
     */
    class OnClickListener(val clickListener: (character: Character) -> Unit) {
        fun onClick(character: Character) = clickListener(character)
    }

}