package com.example.utp_tam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun BookingPage(onBackClick: () -> Unit, onMoreClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF5F5F5))
    ) {
        // Top Section with Plane Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bookingbg),
                contentDescription = "Booking Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp).graphicsLayer(rotationZ = 180f)
                    )
                }
                Text(
                    text = "Booking",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Button(
                    onClick = onMoreClick,
                    colors = ButtonDefaults.buttonColors(containerColor = GarudaBlue),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp)
                ) {
                    Text(text = "More", color = Color.White)
                }
            }

            // Tabs
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(text = "Round Trip", color = Color.White, fontWeight = FontWeight.SemiBold)
                Text(text = "One Way", color = Color.White.copy(alpha = 0.7f))
                Text(text = "Recent", color = Color.White.copy(alpha = 0.7f))
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .offset(y = (-20).dp)
        ) {
            // Origin & Destination Card
            BookingInputCard {
                BookingInputRow(
                    iconRes = R.drawable.departure,
                    label = "From",
                    value = "Jakarta (JKT)"
                )
                HorizontalDivider(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 48.dp))
                BookingInputRow(
                    iconRes = R.drawable.arrival,
                    label = "To",
                    value = "Arrival City"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Dates Card
            BookingInputCard {
                BookingInputRow(
                    iconRes = R.drawable.date,
                    label = "Departure Date",
                    value = "Thu, 16 Apr 2026"
                )
                HorizontalDivider(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 48.dp))
                BookingInputRow(
                    iconRes = R.drawable.date,
                    label = "Return Date",
                    value = "Sat, 18 Apr 2026"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Passenger Card
            BookingInputCard {
                BookingInputRow(
                    iconRes = R.drawable.passenger,
                    label = "Passenger(s) and Cabin Class",
                    value = "1 Adult in Economy Class"
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Promo Code Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.voucher),
                    contentDescription = "Promo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Do You have a promo code?",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Go",
                        tint = Color(0xFF64B5F6),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Search Button
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6))
            ) {
                Text(
                    text = "Search Flight",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BookingInputCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}

@Composable
fun BookingInputRow(iconRes: Int, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = label, color = Color.Gray, fontSize = 12.sp)
            Text(text = value, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingPagePreview() {
    BookingPage(onBackClick = {}, onMoreClick = {})
}
