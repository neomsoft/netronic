package com.example.netronic.ui.users

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.netronic.data.entities.User
import com.example.netronic.databinding.ItemUserBinding

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding: ItemUserBinding by viewBinding()

    fun bind(item: User, itemClickDirection: (item: User) -> NavDirections) {
        viewBinding.textTitle.text = item.name

        Glide.with(itemView)
            .load(item.photo)
            .into(viewBinding.imageMoviePoster)

        itemView.setOnClickListener {
            findNavController(itemView).navigate(itemClickDirection(item))
        }
    }
}