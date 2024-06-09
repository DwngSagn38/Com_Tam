package com.example.com_tam.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam.ui.theme.navigator.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun LoginScreen(naviController: NavController, repositoryUser: RepositoryUser) {
	val context = LocalContext.current
	var email by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var errorMessage by remember { mutableStateOf<String?>(null) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.Black),
		verticalArrangement = Arrangement.Center
	) {
		Column(
			modifier = Modifier
				.fillMaxHeight(0.5f)
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Bottom
		) {
			Text(
				text = "Đăng nhập",
				fontSize = 32.sp,
				color = Color.White,
				fontWeight = FontWeight(900),
			)
			Spacer(modifier = Modifier.height(25.dp))

			Image(
				painter = painterResource(id = R.drawable.logosplash), contentDescription = "",
				modifier = Modifier.fillMaxSize(0.8f)
			)

			Text(
				text = "Chào mừng bạn quay trở lại!",
				fontSize = 20.sp,
				color = Color.White,
			)
			Spacer(modifier = Modifier.height(25.dp))
		}
		Column(
			modifier = Modifier
				.fillMaxHeight(0.7f)
				.padding(horizontal = 16.dp),
			verticalArrangement = Arrangement.SpaceEvenly,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			InputField(label = "Email", value = email, onValueChange = { email = it })
			InputField(label = "Password", value = password, onValueChange = { password = it })

			errorMessage?.let {
				Text(text = it, color = Color.Red, fontSize = 14.sp)
			}

			Row(
				modifier = Modifier
					.clip(RoundedCornerShape(30.dp))
					.width(150.dp)
					.height(50.dp)
					.background(color = Color("#FE724C".toColorInt())),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) {
				Text(text = "Xác nhận", color = Color.White, fontSize = 18.sp,
					modifier = Modifier.clickable {
						loginUser(email, password, repositoryUser, naviController,
							onError = { error ->
							errorMessage = error
						},
							onConfirm = {
								Toast.makeText(context,"Đăng nhập thành công",Toast.LENGTH_SHORT).show()
							})
					})
			}

			Text(text =
			buildAnnotatedString {
				append("Chưa có tài khoản? ")

				withStyle(
					SpanStyle(
						color = Color.Red,
						fontWeight = FontWeight(600)
					)
				) {
					append("Đăng ký ngay!")
				}
			},
				color = Color.White, fontSize = 16.sp,
				modifier = Modifier.clickable {
					naviController.navigate(Screen.Sign_inScreen.route)
				})

		}

	}

}

@Composable
fun InputField(
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

fun loginUser(email: String,
			  password: String,
			  repositoryUser: RepositoryUser,
			  naviController: NavController,
			  onError: (String?) -> Unit,
			  onConfirm : () -> Unit) {
	CoroutineScope(Dispatchers.IO).launch {
		val user = repositoryUser.getUserByEmail(email)

		if (email.isEmpty() || password.isEmpty()) {
			withContext(Dispatchers.Main) {
				onError("Vui lòng điền đầy đủ thông ")
			}
		}else if (user?.email != email || user?.password != password) {
			withContext(Dispatchers.Main) {
				onError("Email hoặc mật khẩu không chính xác.")
			}
		} else {
			withContext(Dispatchers.Main) {
				naviController.navigate(Screen.FurnitureApp.route)
				onConfirm()
			}
		}

	}
}

