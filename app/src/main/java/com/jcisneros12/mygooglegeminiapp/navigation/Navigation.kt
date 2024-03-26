package com.jcisneros12.mygooglegeminiapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jcisneros12.mygooglegeminiapp.feature.story_generator.StoryGeneratedScreen
import com.jcisneros12.mygooglegeminiapp.feature.story_generator.StoryGeneratorScreen
import com.jcisneros12.mygooglegeminiapp.feature.welcome.WelcomeScreen


/**
 * @author Juan Cisneros on 07/03/2024
 */

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route){
        composable(Screen.WelcomeScreen.route){
            WelcomeScreen(navController)
        }
        composable(Screen.StoryGeneratorScreen.route){
            StoryGeneratorScreen(navController)
        }
        composable(Screen.StoryGeneratedScreen.route + "/{promptStructure}", arguments = listOf(
            navArgument("promptStructure") { type = NavType.StringType }
        )){ navBackStackEntry ->
            navBackStackEntry.arguments?.getString("promptStructure").toString().let { promptString ->
                StoryGeneratedScreen(
                    navController,
                    promptString
                )
            }
        }
        composable(Screen.StorySavedListScreen.route){
            // todo ...
        }
    }
}