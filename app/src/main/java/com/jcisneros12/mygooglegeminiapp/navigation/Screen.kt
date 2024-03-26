package com.jcisneros12.mygooglegeminiapp.navigation


/**
 * @author Juan Cisneros on 07/03/2024
 */

sealed class Screen(val route: String) {
    data object WelcomeScreen: Screen(route = RouteConstants.WELCOME_ROUTE_SCREEN)
    data object StoryGeneratorScreen: Screen(route = RouteConstants.STORY_GENERATOR_SCREEN)
    data object StoryGeneratedScreen: Screen(route = RouteConstants.STORY_GENERATED_SCREEN)
    data object StorySavedListScreen: Screen(route = RouteConstants.STORY_SAVED_LIST_SCREEN)
}