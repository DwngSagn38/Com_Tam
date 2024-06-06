package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.com_tam.R

@Preview
@Composable
fun Sign_inScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.Black),
		verticalArrangement =  Arrangement.Center
	) {
		Column(
			modifier = Modifier
				.padding(top = 20.dp)
				.fillMaxHeight(0.30f)
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			Text(
				text = "Đăng ký",
				fontSize = 32.sp,
				color = Color.White,
				fontWeight = FontWeight(900),
			)
			Spacer(modifier = Modifier.height(20.dp))
			Image(
				painter = painterResource(id = R.drawable.logosplash), contentDescription = "",
				modifier = Modifier.fillMaxSize(1f)
			)
		}
		Column(
			modifier = Modifier
				.fillMaxHeight()
				.fillMaxWidth()
				.padding(horizontal = 16.dp),
			verticalArrangement = Arrangement.SpaceEvenly,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			InputField(label = "Username", value = "", onValueChange = {})
			InputField(label = "Email", value = "", onValueChange = {})
			InputField(label = "Number", value = "", onValueChange = {})
			InputField(label = "Password", value = "", onValueChange = {})
			InputField(label = "Confirm Password", value = "", onValueChange = {})
			Row(
				modifier = Modifier
					.clip(RoundedCornerShape(30.dp))
					.width(150.dp)
					.height(50.dp)
					.background(color = Color("#FE724C".toColorInt())),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) {
				Text(text = "Xác nhận", color = Color.White, fontSize = 18.sp)
			}
			
		}
		
		
	}
	
}

@Composable
fun TextInput(
	label: String,
	value: String,
	onValueChange: (String) -> Unit
) {
	Column(
	) {
		Text(text = label, fontSize = 16.sp, color = Color.White)
		Spacer(modifier = Modifier.height(5.dp))
		OutlinedTextField(
			value = value,
			onValueChange = onValueChange,
			modifier = Modifier
				.fillMaxWidth()
				.clip(shape = RoundedCornerShape(10.dp))
				.background(Color("#D9D9D9".toColorInt()))
				.height(50.dp)
		
		)
	}
}
