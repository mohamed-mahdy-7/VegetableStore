package com.example.vegetablestore.view.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vegetablestore.R
import com.example.vegetablestore.navigation.MainAction
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect


@Composable
fun SplashscreenView(action: MainAction) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
            )
        }
    }

    LaunchedEffect(key1 = true) {
        delay(3000)
        action.gotoOnBoarding()
    }
}