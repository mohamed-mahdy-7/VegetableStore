package com.example.vegetablestore.navigation

import androidx.annotation.StringRes
import com.example.vegetablestore.R

sealed class Screen(
    val route: String, @StringRes val resourceId: Int
) {
    object Splash : Screen(
        route = "splash",
        resourceId = R.string.splash
    )

    object OnBoarding : Screen(
        route = "onboarding",
        resourceId = R.string.onboarding
    )

    object Dashboard : Screen(
        route = "dashboard",
        resourceId = R.string.dashboard
    )

    object VegetableDetails : Screen(
        route = "vegetabledetails",
        resourceId = R.string.vegetabledetail
    )

}