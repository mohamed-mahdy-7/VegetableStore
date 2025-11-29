package com.example.vegetablestore.view.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vegetablestore.R
import com.example.vegetablestore.navigation.MainAction
import com.example.vegetablestore.ui.theme.black
import com.example.vegetablestore.ui.theme.ghostWhite
import com.example.vegetablestore.ui.theme.gold
import com.example.vegetablestore.ui.theme.lightBlue
import com.example.vegetablestore.ui.theme.lightSilver
import com.example.vegetablestore.ui.theme.navajoWhite
import com.example.vegetablestore.ui.theme.platinum
import com.example.vegetablestore.ui.theme.white

@Composable
fun HomeScreenView(action: MainAction) {
    var text by remember { mutableStateOf("") }
    val itemList = listOf("Favorite", "Clay", "Cabbage", "Peanut")
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu Image",

                    )
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.onboarding_2),
                    contentDescription = "Profile Image",
                )


            }
            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = "Find Various Kinds of Vegetables",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "With the best conditions and prices",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = lightSilver
                    )
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(itemList.size) { items ->
                    Box(
                        modifier = Modifier
                            .border(
                                color = if (items == 0) gold else Color.Transparent,
                                width = 2.dp,
                                shape = RoundedCornerShape(24.dp)
                            )
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 8.dp,
                                    bottom = 8.dp
                                ),
                            text = itemList[items],
                            color = if (items == 0) gold else Color.LightGray
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(navajoWhite)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(white)
                                    .padding(4.dp)
                            ) {
                                Icon(
                                    modifier = Modifier.size(16.dp, 16.dp),
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Heart Icon",
                                    tint = Color.Red
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.patato),
                                contentDescription = "patata",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.wrapContentHeight()
                            ) {
                                Text(
                                    text = "patata",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = black
                                )
                                Text(
                                    text = "EG 16.0 /Kg",
                                    fontSize = 12.sp,
                                    color = black
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .padding(10.dp)
                                    .background(gold),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add to cart icon",
                                    modifier = Modifier.size(20.dp, 20.dp),
                                    tint = white
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(navajoWhite)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(white)
                                    .padding(4.dp)
                            ) {
                                Icon(
                                    modifier = Modifier.size(16.dp, 16.dp),
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Heart Icon",
                                    tint = Color.Red
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cabbage),
                                contentDescription = "cabbage",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.wrapContentHeight()
                            ) {
                                Text(
                                    text = "cabbage",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = black
                                )
                                Text(
                                    text = "EG 28.0 /Kg",
                                    fontSize = 12.sp,
                                    color = black
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .padding(10.dp)
                                    .background(gold),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add to cart icon",
                                    modifier = Modifier.size(20.dp, 20.dp),
                                    tint = white
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Lagi Diskon Nih",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "More",
                    fontSize = 12.sp,
                    color = gold
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .weight(0.2f)
                            .height(60.dp)
                            .background(lightBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pumpkin),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .weight(0.55f)
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "Summer squash",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Suitable for reducing almond weight",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(0.25f)
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "EG 9.60/Kg",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = gold,
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}