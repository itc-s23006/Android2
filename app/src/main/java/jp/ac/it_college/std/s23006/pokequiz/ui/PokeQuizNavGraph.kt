package jp.ac.it_college.std.s23006.pokequiz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.ac.it_college.std.s23006.pokequiz.ui.generation.GenerationScreen
import jp.ac.it_college.std.s23006.pokequiz.ui.home.HomeScreen
import jp.ac.it_college.std.s23006.pokequiz.ui.navigation.PokeQuizDestinations
import jp.ac.it_college.std.s23006.pokequiz.ui.navigation.PokeQuizNavigationActions

@Composable
fun PokeQuizNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navActions: PokeQuizNavigationActions = remember(navController) {
        PokeQuizNavigationActions(navController)
    }
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = PokeQuizDestinations.HOME_ROUTE
    ) {
        composable(
            route = PokeQuizDestinations.HOME_ROUTE
        ) {
            HomeScreen(
                onStartClick = {
                    navActions.navigateToGenerationSelect()
                }
            )
        }
        composable(
            route = PokeQuizDestinations.GENERATION_ROUTE
        ) {
            GenerationScreen()
        }
    }
}