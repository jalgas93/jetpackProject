package com.octobank.jetpack_3_1.presentation.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.octobank.jetpack_3_1.presentation.onboarding.OnBoardingScreen
import com.octobank.jetpack_3_1.presentation.onboarding.OnBoardingViewModel


@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
           navigation(
               route = Route.AppStartNavigation.route,
               startDestination = Route.OnBoardingScreen.route
           ){
               composable(
                   route = Route.OnBoardingScreen.route
               ){
                   val viewModel: OnBoardingViewModel = hiltViewModel()
                   OnBoardingScreen(
                       event = viewModel::onEvent
                   )
               }

           }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigation.route
        ){
            composable(
                route = Route.NewsNavigation.route
            ){
             Text(text = "News")
            }

        }

    }
}