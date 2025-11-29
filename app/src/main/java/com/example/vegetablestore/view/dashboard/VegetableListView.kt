package com.example.vegetablestore.view.dashboard

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vegetablestore.R
import com.example.vegetablestore.model.Vegetable
import com.example.vegetablestore.navigation.MainAction
import com.example.vegetablestore.ui.theme.aliceBlue
import com.example.vegetablestore.ui.theme.azureishWhite
import com.example.vegetablestore.ui.theme.cultured
import com.example.vegetablestore.ui.theme.ghostWhite
import com.example.vegetablestore.ui.theme.gold
import com.example.vegetablestore.ui.theme.lightSilver
import com.example.vegetablestore.ui.theme.platinum
import com.example.vegetablestore.ui.theme.seashell
import com.example.vegetablestore.ui.theme.white

@Composable
fun VegetableListView(action: MainAction) {
    var text by remember { mutableStateOf("") }
    val vegetableItemList = listOf(
        Vegetable(
            image = R.drawable.carrot,
            name = "Carrot",
            price = "Eg 10/Kg",
            seashell
        ),
        Vegetable(
            image = R.drawable.tomato,
            name = "Tomato",
            price = "Eg 10/Kg",
            aliceBlue
        ),
        Vegetable(
            image = R.drawable.pumpkin,
            name = "Pumpkin",
            price = "Eg 10/Kg",
            cultured
        ),
        Vegetable(
            image = R.drawable.cauliflower,
            name = "Cauli Flower",
            price = "Eg 13/Kg",
            azureishWhite
        ),
        Vegetable(
            image = R.drawable.red_capsicum,
            name = "Capsicum",
            price = "Eg 16/Kg",
            seashell
        ),
        Vegetable(
            image = R.drawable.onion,
            name = "Onion",
            price = "Eg 18/Kg",
            aliceBlue
        ),
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.left_arrow),
                        modifier = Modifier.size(16.dp),
                        contentDescription = null
                    )
                    Text(
                        text = "Complete your nutrition",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.filter),
                        modifier = Modifier.size(24.dp),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(36.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = ghostWhite,
                        unfocusedContainerColor = ghostWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    ),
                    shape = RoundedCornerShape(32.dp),
                    singleLine = true,
                    onValueChange = { text = it },
                    placeholder = {
                        Text(
                            text = "Carl Vegetables",
                            color = platinum
                        )
                    },
                    leadingIcon = {
                        77
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search Icon",
                            tint = lightSilver
                        )
                    },
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            items(vegetableItemList.windowed(2, 2, true)) { subList ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    subList.forEach { item ->
                        Card(
                            modifier = Modifier
                                .fillParentMaxWidth(0.5f)
                                .padding(4.dp)
                                .background(item.cardBg),
                            shape = RoundedCornerShape(16.dp),
                            onClick = { action.gotoVegetableDetails }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = item.image),
                                        modifier = Modifier.size(85.dp),
                                        contentDescription = null,
                                    )
                                }
                                Spacer(modifier = Modifier.height(24.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        modifier = Modifier.wrapContentHeight()
                                    ) {
                                        Text(
                                            text = item.name,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = item.price,
                                            fontSize = 12.sp,
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(16.dp))
                                            .padding(8.dp)
                                            .background(gold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            modifier = Modifier.size(16.dp, 16.dp),
                                            tint = white,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
