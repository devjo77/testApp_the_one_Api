package com.technisys.test.ui.character

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technisys.test.R
import com.technisys.test.model.Character
import com.technisys.test.network.ApiStatusEnum

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Character>?) {
    val adapter = recyclerView.adapter as CharacterAdapter
    adapter.submitList(data)
}

@BindingAdapter("ApiStatus")
fun bindStatus(statusImageView: ImageView, statusEnum: ApiStatusEnum?) {
    when (statusEnum) {
        ApiStatusEnum.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatusEnum.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatusEnum.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
