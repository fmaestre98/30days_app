package com.example.a30daysfilms

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.a30daysfilms.domain.Film
import com.example.a30daysfilms.ui.screens.DetailScreen
import com.example.a30daysfilms.ui.screens.FilmViewModel
import com.example.a30daysfilms.ui.screens.ListScreen
import com.example.a30daysfilms.ui.screens.SplashScreen
import com.example.a30daysfilms.ui.theme.DaysFilmsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysFilmsApp() {

    DaysFilmsTheme(dynamicColor = true) {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        // Fetch your currentDestination:
        val currentDestination = currentBackStack?.destination
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { if (currentDestination?.route != SPLASH) TopAppBar() }
        ) {

            DaysFilmsNavHost(navController = navController, modifier = Modifier.padding(it))
        }
    }


}

@Composable
fun DaysFilmsNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = SPLASH,
        modifier = modifier
    ) {
        composable(route = SPLASH) {
            SplashScreen {
                navController.popBackStack()
                navController.navigate(route = MOVIES)
            }
        }
        navigation(route = MOVIES, startDestination = LIST) {
            composable(route = LIST) {
                val viewModel = it.sharedViewModel<FilmViewModel>(navController = navController)
                val films = viewModel.filmPagerFlow.collectAsLazyPagingItems()
                ListScreen(films = films) { film: Film ->
                    viewModel.selectFilm(film)
                    navController.navigate(route = "$DETAILS")
                }
            }

            composable(
                route = "$DETAILS",
            ) {
                val viewModel = it.sharedViewModel<FilmViewModel>(navController = navController)
                val state by viewModel.state.collectAsState()
                DetailScreen(film =state.selectedFilm!!)
            }

        }

    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavHostController): FilmViewModel {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel<FilmViewModel>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel<FilmViewModel>(parentEntry)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.surface
            )
        },
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.primary)
    )
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

@Preview
@Composable
fun TopBarPreview() {
    TopAppBar()
}