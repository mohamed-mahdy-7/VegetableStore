package com.example.vegetablestore.navigation

import android.window.SplashScreenView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vegetablestore.utils.isOnboardingCompleted
import com.example.vegetablestore.view.dashboard.DashboardView
import com.example.vegetablestore.view.dashboard.VegetableDetailsView
import com.example.vegetablestore.view.welcome.OnBoardingView
import com.example.vegetablestore.view.welcome.SplashscreenView

@Composable
fun NavGraph() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val action = remember(navController) { MainAction(navController) }
    val startDestination = if (isOnboardingCompleted(context)) {
        Screen.Dashboard.route
    } else {
        Screen.Splash.route
    }
    NavHost(
        navController,
        startDestination = startDestination
    ) {
        composable(Screen.Splash.route) {
            SplashscreenView(action)
        }
        composable(Screen.OnBoarding.route) {
            OnBoardingView(action)
        }
        composable(Screen.Dashboard.route) {
            DashboardView(action)
        }
        composable(Screen.VegetableDetails.route) {
            VegetableDetailsView(action)
        }
    }
}

class MainAction(private val navController: NavHostController) {
    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
    val gotoOnBoarding: () -> Unit = {
        navController.navigate(Screen.OnBoarding.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    val gotoOnDashbord: () -> Unit = {
        navController.navigate(Screen.Dashboard.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    val gotoVegetableDetails: () -> Unit = {
        navController.navigate(Screen.VegetableDetails.route)
    }

}
