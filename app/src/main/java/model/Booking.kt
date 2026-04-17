package model
import androidx.annotation.DrawableRes

data class Booking(
    val from: String,
    val to: String,
    val departureDate: String,
    val returnDate: String,
    val passengers: List<Passenger>,
    @DrawableRes val imageResourceId: Int
)
