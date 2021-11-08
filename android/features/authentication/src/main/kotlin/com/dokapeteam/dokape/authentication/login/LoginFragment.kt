package com.dokapeteam.dokape.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dokapeteam.dokape.authentication.databinding.FragmentLoginBinding
import com.dokapeteam.dokape.common.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // SAMPLE GET ARGUMENTS
        val sampleId = navController.currentBackStackEntry?.arguments?.getString("sampleId")
        binding.textView.text = sampleId.toString()
    }
}
