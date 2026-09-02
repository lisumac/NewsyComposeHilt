package com.rkd.newsycomposehilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rkd.newsycomposehilt.domain.model.Article
import com.rkd.newsycomposehilt.presentation.details.DetailsScreen
import com.rkd.newsycomposehilt.presentation.home.HomeRoute
import com.rkd.newsycomposehilt.presentation.home.HomeScreen
import com.rkd.newsycomposehilt.presentation.home.HomeViewModel
import com.rkd.newsycomposehilt.presentation.splashScreen.SplashScreen
import com.rkd.newsycomposehilt.ui.theme.NewsyComposeHiltTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsyComposeHiltTheme {
              //  HomeRoute()
                NavGraph()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsyComposeHiltTheme {
        Greeting("Android")
    }
}

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    var selectedArticle by remember {
        mutableStateOf<Article?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {

            SplashScreen(
                onNavigateToHome = {

                    navController.navigate("home") {

                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("home") {

            HomeRoute(
                onArticleClick = { article ->

                    // Save the selected article
                    selectedArticle = article

                    // Navigate to details
                    navController.navigate("details")
                }
            )
        }

        composable("details") {

            selectedArticle?.let { article ->

                DetailsScreen(
                    article = article,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}