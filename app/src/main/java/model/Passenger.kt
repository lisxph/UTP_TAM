package model
import androidx.annotation.DrawableRes

data class Passenger(
    val total: Int,
    val cabinClass: String,
    @DrawableRes val imageResourceId: Int
)
