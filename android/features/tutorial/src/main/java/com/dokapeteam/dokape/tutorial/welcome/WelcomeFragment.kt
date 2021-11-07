package com.dokapeteam.dokape.tutorial.welcome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dokapeteam.dokape.common.base.BaseFragment
import com.dokapeteam.dokape.tutorial.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWelcomeBinding
        get() = FragmentWelcomeBinding::inflate
}