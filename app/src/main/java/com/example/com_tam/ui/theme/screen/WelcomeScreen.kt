package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.ui.theme.navigator.Screen
import kotlinx.coroutines.delay


@Composable
fun WelcomeScreen(navController: NavController){
	val coroutineScope = rememberCoroutineScope()

	LaunchedEffect(Unit) {
		// Chờ 3 giây
		delay(3000)

		// Chuyển đến màn hình Login
		navController.navigate(Screen.LoginScreen.route)
	}
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black)
	) {
		Image(painter = painterResource(id = R.drawable.logosplash),
		contentDescription = "Backround logo",
		contentScale = ContentScale.Crop,
		modifier = Modifier
			.size(350.dp, 350.dp))
	}

	// Hiển thị animation loading
	Box(modifier = Modifier
		.fillMaxSize().padding(top = 700.dp)
		, contentAlignment = Alignment.Center) {
		LinearProgressIndicator()
	}
}