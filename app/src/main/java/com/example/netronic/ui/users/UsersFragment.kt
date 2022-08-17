package com.example.netronic.ui.users

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.netronic.R
import com.example.netronic.databinding.FragmentUsersBinding
import com.example.netronic.extensions.ViewModelExtensions.viewModels
import com.example.netronic.presentation.users.UsersState
import com.example.netronic.presentation.users.UsersViewModel

class UsersFragment : Fragment(R.layout.fragment_users) {

    private val model: UsersViewModel by viewModels()
    private val binding: FragmentUsersBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UsersAdapter(view.context) {
            UsersFragmentDirections.actionUsersFragmentToUserDetails(it)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerView.addItemDecoration(UserItemDecoration())

        model.usersLiveData.observe(this as LifecycleOwner) {
            binding.tvError.isVisible = it is UsersState.Error
            binding.progress.isVisible = it is UsersState.Loading
            binding.recyclerView.isVisible = it is UsersState.Data
            binding.fabLoad.isVisible = it !is UsersState.Loading
            binding.fabHistory.isVisible = it !is UsersState.Loading

            if (it is UsersState.Data) {
                adapter.submitList(it.users)
            }
        }

        binding.fabLoad.setOnClickListener {
            model.onBtnLoadClick()
        }

        binding.fabHistory.setOnClickListener {
            findNavController().navigate(R.id.action_UsersFragment_to_UsersHistoryFragment)
        }
    }
}