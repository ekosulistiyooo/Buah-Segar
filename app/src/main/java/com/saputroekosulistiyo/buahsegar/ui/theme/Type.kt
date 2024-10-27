package com.saputroekosulistiyo.buahsegar.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import com.saputroekosulistiyo.buahsegar.R

// Mendefinisikan keluarga font untuk Abril Fatface
val AbrilFatface = FontFamily(
    // Menggunakan font reguler dari file Abril Fatface
    Font(R.font.abril_fatface_regular)
)

// Mendefinisikan keluarga font untuk Montserrat
val Montserrat = FontFamily(
    // Menggunakan font reguler dari file Montserrat
    Font(R.font.montserrat_regular),
    // Menggunakan font bold dari file Montserrat dengan berat Bold
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

// Mendefinisikan tipografi untuk aplikasi
val Typography = Typography(
    // Gaya teks untuk tampilan besar
    displayLarge = TextStyle(
        fontFamily = Montserrat, // Menggunakan keluarga font Montserrat
        fontWeight = FontWeight.Bold, // Menggunakan berat Bold
        fontSize = 36.sp // Ukuran font 36 sp
    ),
    // Gaya teks untuk tampilan medium
    displayMedium = TextStyle(
        fontFamily = Montserrat, // Menggunakan keluarga font Montserrat
        fontWeight = FontWeight.Bold, // Menggunakan berat Bold
        fontSize = 20.sp // Ukuran font 20 sp
    ),
    // Gaya teks untuk label kecil
    labelSmall = TextStyle(
        fontFamily = Montserrat, // Menggunakan keluarga font Montserrat
        fontWeight = FontWeight.Bold, // Menggunakan berat Bold
        fontSize = 14.sp // Ukuran font 14 sp
    ),
    // Gaya teks untuk tubuh besar
    bodyLarge = TextStyle(
        fontFamily = Montserrat, // Menggunakan keluarga font Montserrat
        fontWeight = FontWeight.Normal, // Menggunakan berat Normal
        fontSize = 14.sp // Ukuran font 14 sp
    )
)
