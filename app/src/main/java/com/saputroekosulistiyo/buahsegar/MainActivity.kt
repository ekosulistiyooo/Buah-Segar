
package com.saputroekosulistiyo.buahsegar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.saputroekosulistiyo.buahsegar.data.Buah
import com.saputroekosulistiyo.buahsegar.data.buah
import com.saputroekosulistiyo.buahsegar.ui.theme.BuahSegarTheme

// Kelas utama yang mewarisi ComponentActivity
class MainActivity : ComponentActivity() {
    // Metode onCreate dipanggil saat Activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Mengatur tema aplikasi dengan BuahSegarTheme
            BuahSegarTheme {
                // Kontainer dengan warna latar dari tema
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Memanggil fungsi BuahSegarApp untuk menampilkan konten aplikasi
                    BuahSegarApp()
                }
            }
        }
    }
}

// Fungsi Composable utama untuk menampilkan aplikasi
@Composable
fun BuahSegarApp() {
    Scaffold(
        topBar = {
            // Memanggil fungsi BuahTopAppBar untuk menampilkan AppBar di bagian atas
            BuahTopAppBar()
        }
    ) { it ->
        // Menampilkan daftar buah menggunakan LazyColumn
        LazyColumn(contentPadding = it) {
            // Mengisi daftar dengan item buah
            items(buah) {
                // Menampilkan tiap item buah dengan BuahItem
                BuahItem(
                    buah = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

// Fungsi Composable untuk menampilkan item buah
@Composable
fun BuahItem(
    buah: Buah,
    modifier: Modifier = Modifier
) {
    // Variabel untuk mengatur apakah item diperluas atau tidak
    var expanded by remember { mutableStateOf(false) }
    // Animasi perubahan warna ketika item diperluas
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.tertiaryContainer,
        label = "",
    )
    // Kartu untuk menampilkan informasi buah
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                // Menampilkan ikon buah
                BuahIcon(buah.imageResourceId)
                // Menampilkan informasi nama dan harga buah
                BuahInformation(buah.name, buah.harga)
                Spacer(Modifier.weight(1f))
                // Tombol untuk memperluas item
                BuahItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            // Menampilkan keterangan buah jika item diperluas
            if (expanded) {
                BuahKet(
                    buah.keterangan, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

// Fungsi untuk tombol expand/collapse item
@Composable
private fun BuahItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        // Menampilkan ikon berdasarkan status item (expand/collapse)
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

// Fungsi untuk AppBar di bagian atas aplikasi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuahTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Menampilkan logo di AppBar
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null
                )
                // Menampilkan judul aplikasi
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

// Fungsi untuk menampilkan ikon buah
@Composable
fun BuahIcon(
    @DrawableRes buahIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(buahIcon),
        contentDescription = null
    )
}

// Fungsi untuk menampilkan informasi nama dan harga buah
@Composable
fun BuahInformation(
    @StringRes buahName: Int,
    buahHarga: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Menampilkan nama buah
        Text(
            text = stringResource(buahName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        // Menampilkan harga buah
        Text(
            text = stringResource(R.string.harga_buah, buahHarga),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

// Fungsi untuk menampilkan keterangan buah
@Composable
fun BuahKet(
    @StringRes buahKet: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        // Label "Tentang" untuk keterangan
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        // Menampilkan keterangan buah
        Text(
            text = stringResource(buahKet),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

// Pratinjau untuk tema terang aplikasi
@Preview
@Composable
fun BuahSegarPreview() {
    BuahSegarTheme(darkTheme = false) {
        BuahSegarApp()
    }
}

// Pratinjau untuk tema gelap aplikasi
@Preview
@Composable
fun BuahSegarDarkThemePreview() {
    BuahSegarTheme(darkTheme = true) {
        BuahSegarApp()
    }
}
