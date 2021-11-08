package com.dokapeteam.dokape.navigation

import android.content.Context
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object AuthenticationDirections : KoinComponent {
    private val context by inject<Context>()

    val Login = createDirection(
        direction = context.getString(R.string.login_route),
        baseRoute = context.getString(R.string.login_base_route),
        arguments = listOf(navArgument("sampleId") { type = NavType.StringType })
    )
}
