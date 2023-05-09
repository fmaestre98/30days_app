package com.example.a30daysfilms.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfilms.R
import com.example.a30daysfilms.ui.theme.DaysFilmsTheme
import kotlinx.coroutines.delay

const val SPLASH_TIMEOUT=1500L

@Composable
fun SplashScreen(onstart: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = "Splash Image (Not Important)",
            modifier = Modifier.size(200.dp).clip(RoundedCornerShape(30.dp))

        )
    }

    LaunchedEffect(true) {
        delay(SPLASH_TIMEOUT)
        onstart()
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashPreview() {
    DaysFilmsTheme {
        SplashScreen {}
    }
}