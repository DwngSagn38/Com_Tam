package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.ui.theme.navigator.Screen

@Composable
fun EditProfileScreen(navController: NavController){
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black),
		horizontalAlignment =  Alignment.CenterHorizontally,
	) {
		Row(
			modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
			horizontalArrangement = Arrangement.SpaceAround,
			verticalAlignment = Alignment.CenterVertically
		)
		{
			Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Back",
				modifier = Modifier
					.padding(0.dp, 50.dp, 0.dp, 0.dp)
					.size(18.dp)
					.clickable { navController.navigate(route = Screen.ProfileScreen.route)},
				tint = Color.White,)
			Text(
				text = "Sửa hồ sơ",
				textAlign = TextAlign.Center,
				fontWeight = FontWeight(800),
				fontSize = 24.sp,
				color = Color.White,
				modifier = Modifier.padding(top = 50.dp)
			)
			Row(
				modifier = Modifier.width(20.dp)
			){
			
			}
		}
		Spacer(modifier = Modifier.height(130.dp))
		Column(
			modifier = Modifier
				.fillMaxSize()
				.clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
				.background(color = Color("#252121".toColorInt())),
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Spacer(modifier = Modifier.height(30.dp))
			Column(
				modifier = Modifier
					.fillMaxHeight(0.8f)
					.fillMaxWidth()
					.padding(16.dp, 30.dp, 16.dp, 0.dp),
				verticalArrangement = Arrangement.SpaceEvenly,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				InputField(label = "Họ và tên", value = "", onValueChange = {})
				InputField(label = "Số điện thoại", value = "", onValueChange = {})
				InputField(label = "Phường", value = "", onValueChange = {})
				InputField(label = "Đường", value = "", onValueChange = {})
				InputField(label = "Số nhà", value = "", onValueChange = {})
			}
			Spacer(modifier = Modifier.height(10.dp))
			Divider(Modifier.height(1.dp), color = Color.Black)
			Spacer(modifier = Modifier.height(20.dp))
			Row(
				modifier = Modifier
					.clip(RoundedCornerShape(30.dp))
					.width(150.dp)
					.height(50.dp)
					.background(color = Color("#FE724C".toColorInt())),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) {
				Text(text = "Lưu", color = Color.White, fontSize = 18.sp,
					modifier = Modifier.clickable { navController.navigate(route = Screen.ProfileScreen.route) })
			}
		}
	}
	Box(
		contentAlignment = Alignment.TopCenter,
		modifier = Modifier
			.fillMaxSize()
			.padding(top = 150.dp)
	) {
		Image(
			painter = painterResource(id = R.drawable.logosplash), contentDescription = "",
			modifier = Modifier
				.size(130.dp)
				.border(12.dp, Color.White, RoundedCornerShape(140.dp)),
			contentScale = ContentScale.Inside)
	}
}
@Composable
fun TextFeld(
	label: String,
	value: String,
	onValueChange: (String) -> Unit
){
	Column(
	) {
		Text(text = label, fontSize = 16.sp, color = Color.White)
		Spacer(modifier = Modifier.height(5.dp))
		OutlinedTextField(
			value = value,
			onValueChange = onValueChange,
			modifier = Modifier
				.clip(shape = RoundedCornerShape(10.dp))
				.background(Color("#D9D9D9".toColorInt()))
			
		)
	}
}
