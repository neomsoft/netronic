package com.example.netronic.ui.history

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.netronic.R
import com.example.netronic.databinding.FragmentUsersHistoryBinding
import com.example.netronic.extensions.ViewModelExtensions.viewModels
import com.example.netronic.presentation.history.UsersHistoryViewModel
import com.example.netronic.presentation.users.UsersState
import com.example.netronic.ui.users.UserItemDecoration
import com.example.netronic.ui.users.UsersAdapter
import com.example.netronic.ui.users.UsersFragmentDirections

class UsersHistoryFragment : Fragment(R.layout.fragment_users_history) {

    private val model: UsersHistoryViewModel by viewModels()
    private val binding: FragmentUsersHistoryBinding by viewBinding()

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UsersAdapter(view.context) {
            UsersHistoryFragmentDirections.actionUsersHistoryFragmentToUserDetails(it)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerView.addItemDecoration(UserItemDecoration())

        model.usersLiveData.observe(this as LifecycleOwner) {
            binding.tvEmpty.isVisible = it is UsersState.Empty
            binding.progress.isVisible = it is UsersState.Loading
            binding.recyclerView.isVisible = it is UsersState.Data

            if (it is UsersState.Data) {
                adapter.submitList(it.users)
            }
        }
    }
}