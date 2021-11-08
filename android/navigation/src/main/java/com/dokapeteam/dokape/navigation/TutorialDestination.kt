package com.dokapeteam.dokape.navigation

import android.content.Context
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object TutorialDestination : KoinComponent {
    private val context by inject<Context>()
    val TutorialWelcome = createDirection(
        direction = context.getString(R.string.tutorial_welcome_route),
    )
}
