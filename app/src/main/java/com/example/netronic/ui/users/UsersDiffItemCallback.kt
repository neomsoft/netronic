package com.example.netronic.ui.users

import androidx.recyclerview.widget.DiffUtil
import com.example.netronic.data.entities.User

object UsersDiffItemCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}