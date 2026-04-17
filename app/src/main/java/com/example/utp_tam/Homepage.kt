package com.example.utp_tam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val GarudaBlue = Color(0xFF004684)
val GarudaLightBlue = Color(0xFF005DAA)

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        HeaderSection()
        BookingCard()
        ActionIconsSection()
        OffersSection()
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Hero Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.3f), Color.Transparent, Color.Black.copy(alpha = 0.5f))
                    )
                )
        )

        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User",
                modifier = Modifier.size(40.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.logogaruda),
                    contentDescription = "Garuda logo",
                    modifier = Modifier.height(40.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                modifier = Modifier.size(32.dp)
            )
        }

        // Hero Text
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 24.dp, top = 80.dp)
        ) {
            Text(
                text = "Bangkok",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "From",
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = "IDR 4,690,200*",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BookingCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .offset(y = (-60).dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = GarudaBlue)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Fly With Garuda Indonesia",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Origin", color = Color.LightGray, fontSize = 12.sp)
                    Text(text = "CGK", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "Jakarta (JKT)", color = Color.LightGray, fontSize = 12.sp)
                }
                Column {
                    Text(text = "Destination", color = Color.LightGray, fontSize = 12.sp)
                    Text(text = "Select", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "Arrival City", color = Color.LightGray, fontSize = 12.sp)
                }
                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.height(60.dp)
                ) {
                    Text(text = "Book Now", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun ActionIconsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .offset(y = (-40).dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActionIcon(iconRes = R.drawable.more1, label = "Check In")
        ActionIcon(iconRes = R.drawable.more2, label = "Flight Status")
        ActionIcon(iconRes = R.drawable.more3, label = "Flight Schedule")
        ActionIcon(iconRes = R.drawable.more8, label = "Excess Baggage\nCalculator")
    }
}

@Composable
fun ActionIcon(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 10.sp,
            color = Color.Black,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            lineHeight = 12.sp
        )
    }
}

@Composable
fun OffersSection() {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 24.dp)) {
        Text(
            text = "Best Offers for Your Trip",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = GarudaBlue
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(listOf(R.drawable.offer1, R.drawable.offer2, R.drawable.offer3)) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Offer",
                    modifier = Modifier
                        .width(300.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage()
}
