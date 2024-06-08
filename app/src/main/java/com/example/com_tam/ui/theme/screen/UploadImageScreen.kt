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
fun UploadImageScreen(navController: NavController) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 12.dp),
			horizontalArrangement = Arrangement.SpaceAround,
			verticalAlignment = Alignment.CenterVertically
		)
		{
			Icon(
				painter = painterResource(id = R.drawable.back), contentDescription = "Back",
				modifier = Modifier
					.padding(0.dp, 50.dp, 0.dp, 0.dp)
					.size(18.dp)
					.clickable { navController.navigate(route = Screen.EditProfileScreen.route) },
				tint = Color.White
			)
			Text(
				text = "Chỉnh sửa ảnh",
				textAlign = TextAlign.Center,
				fontWeight = FontWeight(800),
				fontSize = 24.sp,
				color = Color.White,
				modifier = Modifier.padding(top = 50.dp)
			)
			Row(
				modifier = Modifier.width(20.dp)
			) {
			
			}
		}
		Spacer(modifier = Modifier.height(200.dp))
		Column(
			modifier = Modifier
				.fillMaxSize()
				.clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
				.background(color = Color("#252121".toColorInt())),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			Spacer(modifier = Modifier.height(20.dp))
			Row {
			
			}
			Row {
			
			}
			Column(
				modifier = Modifier.fillMaxWidth(),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				Row(
					modifier = Modifier
						.clip(RoundedCornerShape(30.dp))
						.width(160.dp)
						.height(40.dp)
						.background(color = Color("#D9D9D9".toColorInt())),
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.Center
				) {
					Text(text = "Chọn ảnh từ thư viện", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight(400))
				}
				Spacer(modifier = Modifier.height(15.dp))
				Row(
					modifier = Modifier
						.clip(RoundedCornerShape(30.dp))
						.width(160.dp)
						.height(40.dp)
						.background(color = Color("#D9D9D9".toColorInt())),
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.Center
				) {
					Text(text = "Chụp ảnh mới", color = Color.Black, fontSize = 10.sp)
				}
			}
			Row(
				modifier = Modifier
					.clip(RoundedCornerShape(30.dp))
					.width(200.dp)
					.height(50.dp)
					.background(color = Color("#FE724C".toColorInt())),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) {
				Text(text = "Lưu", color = Color.White, fontSize = 18.sp,
					modifier = Modifier.clickable { navController.navigate(route = Screen.ProfileScreen.route) })
			}
			Row {
			
			}
			Row {
			
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
				.size(280.dp)
				.border(15.dp, Color.White, RoundedCornerShape(140.dp)),
			contentScale = ContentScale.Crop
		)
	}
}
