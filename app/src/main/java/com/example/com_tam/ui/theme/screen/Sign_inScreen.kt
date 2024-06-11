package com.example.com_tam.ui.theme.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.com_tam.DAO.UserDAO
import com.example.com_tam.R
import com.example.com_tam.model.UserModel
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam.ui.theme.navigator.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun Sign_inScreen(naviController: NavController, repositoryUser: RepositoryUser) {
	val context = LocalContext.current
	var name by remember { mutableStateOf("") }
	var sdt by remember { mutableStateOf("") }
	var email by remember { mutableStateOf("") }
	var pass by remember { mutableStateOf("") }
	var confirmPass by remember { mutableStateOf("") }
	var visible by remember { mutableStateOf(true) }
	var visibleCF by remember { mutableStateOf(true) }
	var errorMessage by remember { mutableStateOf<String?>(null) }

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
				.fillMaxWidth()
				.verticalScroll(rememberScrollState()),
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
			horizontalAlignment = Alignment.Start
		) {
			Text(
				text = "Họ và tên",
				color = Color.White,
				fontSize = 14.sp,
				fontWeight = FontWeight(400)
			)
			TextField(
				value = name,
				onValueChange = {name = it},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				colors = TextFieldDefaults.colors(
					focusedContainerColor = Color("#E0E0E0".toColorInt()),
					unfocusedContainerColor = Color.White,
					disabledContainerColor = Color.Gray,
					unfocusedIndicatorColor = Color.Gray,
				)
			)
			Text(
				text = "Phone number",
				color = Color.White,
				fontSize = 14.sp,
				fontWeight = FontWeight(400)
			)
			TextField(
				value = sdt,
				onValueChange = {sdt = it},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				colors = TextFieldDefaults.colors(
					focusedContainerColor = Color("#E0E0E0".toColorInt()),
					unfocusedContainerColor = Color.White,
					disabledContainerColor = Color.Gray,
					unfocusedIndicatorColor = Color.Gray,
				)
			)
			Text(
				text = "Email",
				color = Color.White,
				fontSize = 14.sp,
				fontWeight = FontWeight(400)
			)
			TextField(
				value = email,
				onValueChange = {email = it},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				colors = TextFieldDefaults.colors(
					focusedContainerColor = Color("#E0E0E0".toColorInt()),
					unfocusedContainerColor = Color.White,
					disabledContainerColor = Color.Gray,
					unfocusedIndicatorColor = Color.Gray,
				)
			)
			Text(
				text = "PassWord",
				color = Color.White,
				fontSize = 14.sp,
				fontWeight = FontWeight(400)
			)
			TextField(
				value = pass,
				onValueChange = {pass = it},
				trailingIcon = {
					Icon(painter = painterResource( id =
					if(visible) R.drawable.ic_eye else R.drawable.hidden)
						, contentDescription = "visible",
						Modifier
							.clickable { visible = !visible }
							.size(25.dp))
				},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				visualTransformation =
				if (visible) PasswordVisualTransformation()
				else VisualTransformation.None,
				colors = TextFieldDefaults.colors(
					focusedContainerColor = Color("#E0E0E0".toColorInt()),
					unfocusedContainerColor = Color.White,
					disabledContainerColor = Color.Gray,
					unfocusedIndicatorColor = Color.Gray,
				)
			)
			Text(
				text = "Confirm PassWord",
				color = Color.White,
				fontSize = 14.sp,
				fontWeight = FontWeight(400)
			)
			TextField(
				value = confirmPass,
				onValueChange = {confirmPass = it},
				trailingIcon = {
					Icon(painter = painterResource( id =
					if(visibleCF) R.drawable.ic_eye else R.drawable.hidden)
						, contentDescription = "visible",
						Modifier
							.clickable { visibleCF = !visibleCF }
							.size(25.dp))
				},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				visualTransformation =
				if (visibleCF) PasswordVisualTransformation()
				else VisualTransformation.None,
				colors = TextFieldDefaults.colors(
					focusedContainerColor = Color("#E0E0E0".toColorInt()),
					unfocusedContainerColor = Color.White,
					disabledContainerColor = Color.Gray,
					unfocusedIndicatorColor = Color.Gray,
				)
			)

			errorMessage?.let {
				Text(text = it, color = Color.Red, fontSize = 14.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
			}

			Button(
				onClick = {
					// Gọi hàm xử lý đăng ký
					registerUser(name, sdt, email, pass, confirmPass, naviController, repositoryUser, onError =  { error ->
						errorMessage = error
					}, onConfirm = {
						Toast.makeText(context,"Đăng ký tài khoản thành công!", Toast.LENGTH_SHORT).show()
					})
				},
				colors = ButtonDefaults.buttonColors(
					containerColor = Color(0xFFFE724C),
					contentColor = Color.White
				),
				modifier = Modifier
					.align(Alignment.CenterHorizontally)
					.clip(RoundedCornerShape(30.dp))
					.width(150.dp)
					.height(50.dp)
			) {
				Text(
					text = "Xác nhận",
					fontSize = 18.sp,
					fontWeight = FontWeight(600)
				)
			}

		}
	}

}

fun registerUser(name: String,
				 sdt: String,
				 email: String,
				 pass: String,
				 confirmPass: String,
				 naviController: NavController,
				 repositoryUser: RepositoryUser,
				 onError: (String?) -> Unit,
				 onConfirm : () -> Unit) {
	// Kiểm tra các trường dữ liệu
	if (name.isEmpty() || sdt.isEmpty() || email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
		onError("Vui lòng điền đầy đủ thông tin. ")
		return
	}

	// Kiểm tra xác nhận mật khẩu
	if (pass != confirmPass) {
		onError("Mật khẩu và xác nhận mật khẩu không khớp.")
		return
	}

	// Thực hiện đăng ký người dùng
	// Gọi phương thức từ repositoryUser để thêm người dùng mới vào cơ sở dữ liệu
	val newUser = UserModel(
		email = email,
		password = pass,
		hoTen = name,
		soDienThoai = sdt,
		role = 1,
		phuong = "",
		duong = "",
		sonha = ""
	)

	CoroutineScope(Dispatchers.IO).launch {
		try {
			repositoryUser.addUser(newUser)
			withContext(Dispatchers.Main) {
				// Chuyển hướng đến màn hình đăng nhập
				naviController.navigate(Screen.LoginScreen.route)
				onConfirm()
			}
		} catch (e: Exception) {
			onError("Đã xảy ra lỗi khi đăng ký người dùng.")
		}
	}

}
