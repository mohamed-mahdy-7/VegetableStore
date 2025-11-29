package com.example.vegetablestore.view.dashboard

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vegetablestore.R
import com.example.vegetablestore.navigation.MainAction

@Composable
fun DashboardView(action: MainAction) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItem = DashboardSection.values().toList()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItem,
                currentSection = sectionState.value,
                onSecitonSelected = { sectionState.value = it }
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value,
            label = "DashboardSectionCrossfade"
        ) { section ->
            when (section) {
                DashboardSection.Home -> HomeScreenView(action)
                DashboardSection.List -> VegetableListView(action)
                DashboardSection.ShoppingCart -> VegetableDetailsView(action)
                DashboardSection.Profile -> Text(text = "Profile Section")
            }

        }

    }
}

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSecitonSelected: (DashboardSection) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = contentColorFor(MaterialTheme.colorScheme.background),
        modifier = Modifier.height(100.dp)
    ) {
        items.forEach { section ->
            val selected = section == currentSection
            val iconRes = if (selected) section.selectedIcon else section.icon
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = section.name
                    )
                },
                label = { Text("") },
                selected = selected,
                onClick = { onSecitonSelected(section) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray
                )
            )
        }

    }
}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int
) {
    Home(R.drawable.home, R.drawable.home),
    List(R.drawable.list, R.drawable.list),
    ShoppingCart(R.drawable.shopping_cart, R.drawable.shopping_cart),
    Profile(R.drawable.user, R.drawable.user)
}