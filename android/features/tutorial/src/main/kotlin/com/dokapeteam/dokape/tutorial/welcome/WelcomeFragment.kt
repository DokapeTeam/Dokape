package com.dokapeteam.dokape.tutorial.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dokapeteam.dokape.common.base.BaseFragment
import com.dokapeteam.dokape.navigation.AuthenticationDirections
import com.dokapeteam.dokape.tutorial.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWelcomeBinding
        get() = FragmentWelcomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.setOnClickListener {
            navController.navigate("${AuthenticationDirections.Login.baseRoute}${binding.editTextTextPersonName.text}")
        }
    }
}
