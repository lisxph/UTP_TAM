package com.example.utp_tam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MorePage(onHomeClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(bottom = 24.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "More",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            IconButton(onClick = onHomeClick) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // Grid Menu
        val menuItems = listOf(
            MenuItem("Check-In", R.drawable.more1),
            MenuItem("Flight Status", R.drawable.more2),
            MenuItem("Flight Schedule", R.drawable.more3),
            MenuItem("BidUpgrade", R.drawable.more4),
            MenuItem("Travel Advisories", R.drawable.more5),
            MenuItem("Add On", R.drawable.more6),
            MenuItem("Promo", R.drawable.more7),
            MenuItem("Excess Baggage\nCalculator", R.drawable.more8),
            MenuItem("Charter", R.drawable.more9),
            MenuItem("KirimAja", R.drawable.more10),
            MenuItem("Travel Docs", R.drawable.more11),
            MenuItem("More Info", R.drawable.more12)
        )

        // Custom Grid Implementation (since LazyVerticalGrid doesn't work well inside verticalScroll)
        val chunkedMenu = menuItems.chunked(3)
        chunkedMenu.forEach { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                rowItems.forEach { item ->
                    MoreMenuItem(item)
                }
                // Add empty boxes if row is not full
                if (rowItems.size < 3) {
                    repeat(3 - rowItems.size) {
                        Spacer(modifier = Modifier.width(100.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Our Products Section
        Text(
            text = "Our Products",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF003366),
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val productImages = listOf(
            ProductItem("Shop", R.drawable.product1),
            ProductItem("Things to Do", R.drawable.product2),
            ProductItem("Onward", R.drawable.product3),
            ProductItem("Colours", R.drawable.product4),
            ProductItem("Cargo", R.drawable.product5)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(productImages) { product ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = product.imageRes),
                        contentDescription = product.name,
                        modifier = Modifier
                            .width(160.dp)
                            .height(240.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = product.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF003366)
                    )
                }
            }
        }
    }
}

data class MenuItem(val name: String, val iconRes: Int)
data class ProductItem(val name: String, val imageRes: Int)

@Composable
fun MoreMenuItem(item: MenuItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFE8E8E8)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.name,
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.name,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            lineHeight = 13.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MorePagePreview() {
    MorePage(onHomeClick = {})
}
