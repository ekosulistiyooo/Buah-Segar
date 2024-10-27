package com.saputroekosulistiyo.buahsegar.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Mendefinisikan bentuk (shapes) yang digunakan dalam tema aplikasi
val Shapes = Shapes(
    // Bentuk kecil dengan sudut membulat 8dp
    small = RoundedCornerShape(8.dp),
    // Bentuk sedang dengan sudut membulat di bagian bawah kiri dan atas kanan sebesar 16dp
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp)
)
