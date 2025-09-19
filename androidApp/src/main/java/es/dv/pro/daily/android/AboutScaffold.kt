package es.dv.pro.daily.android
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.dv.pro.daily.android.ui.Screen
import es.dv.pro.daily.android.ui.aboutScreen
import es.dv.pro.daily.android.ui.articlesScreen
import es.dv.pro.daily.articles.ArticlesViewModel

@Composable
fun AboutScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            articlesViewModel = articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
    articlesViewModel: ArticlesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screen.ARTICLES.route) {
            articlesScreen(
                onAboutBackButton = {
                    // navigate to the about screen
                    navController.navigate(Screen.ABOUT_DEVICE.route)
                },
                articlesViewModel = articlesViewModel
            )
        }

        composable(Screen.ABOUT_DEVICE.route) {
            aboutScreen(
                onBackButton = {
                    // go back to articles (or simply pop)
                    navController.popBackStack()
                }
            )
        }
    }
}