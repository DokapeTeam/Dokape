package com.dokapeteam.dokape.home.di

import com.dokapeteam.dokape.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val HomeModule = module {
    viewModel { HomeViewModel() }
}
