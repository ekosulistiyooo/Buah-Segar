package com.saputroekosulistiyo.buahsegar.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.saputroekosulistiyo.buahsegar.R


// Data class untuk merepresentasikan informasi buah
data class Buah(
    // ID gambar dari drawable yang digunakan untuk menampilkan ikon buah
    @DrawableRes val imageResourceId: Int,
    // ID string untuk nama buah yang diambil dari resource
    @StringRes val name: Int,
    // Harga buah
    val harga: Int,
    // ID string untuk keterangan/deskripsi buah yang diambil dari resource
    @StringRes val keterangan: Int
)

// Daftar objek buah yang berisi informasi gambar, nama, harga, dan deskripsi masing-masing buah
val buah = listOf(
    Buah(R.drawable.anggur, R.string.buah_name_1, 20000, R.string.buah_description_1),
    Buah(R.drawable.apel, R.string.buah_name_2, 25000, R.string.buah_description_2),
    Buah(R.drawable.belimbing, R.string.buah_name_3, 20000, R.string.buah_description_3),
    Buah(R.drawable.ceri, R.string.buah_name_4, 28000, R.string.buah_description_4),
    Buah(R.drawable.delima, R.string.buah_name_5, 30000, R.string.buah_description_5),
    Buah(R.drawable.durian, R.string.buah_name_6, 20000, R.string.buah_description_6),
    Buah(R.drawable.jambumerah, R.string.buah_name_7, 15000, R.string.buah_description_7),
    Buah(R.drawable.jeruk, R.string.buah_name_8, 19000, R.string.buah_description_8),
    Buah(R.drawable.mangga, R.string.buah_name_9, 24000, R.string.buah_description_9),
    Buah(R.drawable.manggis, R.string.buah_name_10, 24000, R.string.buah_description_10),
    Buah(R.drawable.melom, R.string.buah_name_11, 23000, R.string.buah_description_11),
    Buah(R.drawable.naga, R.string.buah_name_12, 25000, R.string.buah_description_12),
    Buah(R.drawable.pepaya, R.string.buah_name_13, 18000, R.string.buah_description_13),
    Buah(R.drawable.pisang, R.string.buah_name_14, 26000, R.string.buah_description_14),
    Buah(R.drawable.rambutan, R.string.buah_name_15, 21000, R.string.buah_description_15),
    Buah(R.drawable.sawo, R.string.buah_name_16, 19000, R.string.buah_description_16),
    Buah(R.drawable.semangka, R.string.buah_name_17, 25000, R.string.buah_description_17),
    Buah(R.drawable.strawberi, R.string.buah_name_18, 30000, R.string.buah_description_18)
)
