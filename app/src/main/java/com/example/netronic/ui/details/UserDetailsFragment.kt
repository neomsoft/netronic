package com.example.netronic.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.netronic.R
import com.example.netronic.databinding.FragmentUserDetailsBinding
import java.text.SimpleDateFormat


class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private val args: UserDetailsFragmentArgs by navArgs()
    private val binding: FragmentUserDetailsBinding by viewBinding()

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view)
            .load(args.user.photo)
            .into(binding.image)

        binding.tvUserId.text = args.user.id
        binding.tvUserName.text = args.user.name
        binding.tvUserAge.text = args.user.age.toString()
        binding.tvUserBirthday.text = SimpleDateFormat(BIRTHDAY_FORMAT).format(args.user.birthday)
        binding.tvUserEmail.text = args.user.email
    }

    private companion object {
        const val BIRTHDAY_FORMAT = "dd.MM.yyyy"
    }
}