package com.dokapeteam.dokape.authentication.di

import com.dokapeteam.dokape.authentication.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AuthenticationModule = module {
    viewModel { LoginViewModel() }
}
