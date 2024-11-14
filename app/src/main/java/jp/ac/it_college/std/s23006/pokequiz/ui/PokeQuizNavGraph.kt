package jp.ac.it_college.std.s23006.pokequiz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgs
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import jp.ac.it_college.std.s23006.pokequiz.ui.generation.GenerationScreen
import jp.ac.it_college.std.s23006.pokequiz.ui.home.HomeScreen
import jp.ac.it_college.std.s23006.pokequiz.ui.navigation.PokeQuizDestinations
import jp.ac.it_college.std.s23006.pokequiz.ui.navigation.PokeQuizDestinationsArgs.CORRECT_ANSWER_COUNT_ARG
import jp.ac.it_college.std.s23006.pokequiz.ui.navigation.PokeQuizDestinationsArgs.GENERATION_ID_ARG
import jp.ac.it_college.std.s23006.pokequiz.ui.navigation.PokeQuizNavigationActions
import jp.ac.it_college.std.s23006.pokequiz.ui.quiz.QuizScreen
import jp.ac.it_college.std.s23006.pokequiz.ui.result.ResultScreen

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
        // タイトル画面
        composable(
            route = PokeQuizDestinations.HOME_ROUTE
        ) {
            HomeScreen(
                onStartClick = {
                    navActions.navigateToGenerationSelect()
                }
            )
        }

        // 世代選択画面
        composable(
            route = PokeQuizDestinations.GENERATION_ROUTE
        ) {
            GenerationScreen(
                onGenerationSelected = {
                    navActions.navigateToQuiz(it)
                }
            )
        }

        // クイズ画面
        composable(
            route = PokeQuizDestinations.QUIZ_ROUTE,
            arguments = listOf(
                navArgument(GENERATION_ID_ARG) {
                    type = NavType.IntType
                }
            )
        ) {
            QuizScreen(
                toResult = {
                    navActions.navigateToResult(it)
                }
            )
        }

        // リザルト画面
        composable(
            route = PokeQuizDestinations.RESULT_ROUTE,
            arguments = listOf(
                navArgument(CORRECT_ANSWER_COUNT_ARG) {
                    type = NavType.IntType
                }
            )
        ) {
            ResultScreen()
        }
    }
}