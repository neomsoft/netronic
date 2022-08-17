package com.example.netronic.ui.users

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.ListAdapter
import com.example.netronic.R
import com.example.netronic.data.entities.User

class UsersAdapter(
    context: Context,
    private val itemClickDirection: (item: User) -> NavDirections
) : ListAdapter<User, UserViewHolder>(UsersDiffItemCallback) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickDirection)
    }
}