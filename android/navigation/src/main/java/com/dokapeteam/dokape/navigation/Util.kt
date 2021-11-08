package com.dokapeteam.dokape.navigation

import androidx.navigation.NamedNavArgument

internal fun createDirection(
    direction: String,
    baseRoute: String = direction,
    arguments: List<NamedNavArgument> = emptyList()
) = object : NavigationCommand {
    override val arguments = arguments
    override val destination = direction
    override val baseRoute = baseRoute
}
