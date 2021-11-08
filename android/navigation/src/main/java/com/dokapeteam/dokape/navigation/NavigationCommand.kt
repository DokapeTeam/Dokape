package com.dokapeteam.dokape.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
    val baseRoute: String

    companion object {
        val Default = createDirection("")
    }
}
