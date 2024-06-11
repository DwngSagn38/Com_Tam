package com.example.com_tam.ui.theme.screen

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.com_tam.model.UserModel
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam.ui.theme.navigator.Screen
import kotlinx.coroutines.launch

@Composable
fun EditProfileScreen(navController: NavController, repositoryUser: RepositoryUser) {
    var user by remember { mutableStateOf<UserModel?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        user = repositoryUser.getUserById(userId)
    }

    if (user == null)
        return

    var hoTen by remember { mutableStateOf("${user?.hoTen}") }
    var soDienThoai by remember { mutableStateOf("${user?.soDienThoai}") }
    var phuong by remember { mutableStateOf("${user?.phuong}") }
    var duong by remember { mutableStateOf("${user?.duong}") }
    var sonha by remember { mutableStateOf("${user?.hoTen}") }

    val onHoTenChange: (String) -> Unit = { newValue ->
        hoTen = newValue // Lưu giá trị mới vào biến hoTen
        user = user?.copy(hoTen = newValue) // Cập nhật giá trị mới vào UserModel
    }

    val onSoDienThoaiChange: (String) -> Unit = { newValue ->
        soDienThoai = newValue // Lưu giá trị mới vào biến soDienThoai
        user = user?.copy(soDienThoai = newValue) // Cập nhật giá trị mới vào UserModel
    }
    val onPhuongChange: (String) -> Unit = { newValue ->
        phuong = newValue
        user = user?.copy(phuong = newValue)
    }
    val onDuongChange: (String) -> Unit = { newValue ->
        duong = newValue
        user = user?.copy(duong = newValue)
    }
    val onSoNhaChange: (String) -> Unit = { newValue ->
        sonha = newValue
        user = user?.copy(sonha = newValue)
    }

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
                    .clickable { navController.popBackStack() },
                tint = Color.White,
            )
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
            ) {

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
                InputField(
                    label = "Họ và tên",
                    value = user?.hoTen ?: "",
                    onValueChange = onHoTenChange
                )
                // InputField cho Số điện thoại
                InputField(
                    label = "Số điện thoại",
                    value = user?.soDienThoai ?: "",
                    onValueChange = onSoDienThoaiChange
                )
                // InputField cho Phường
                InputField(
                    label = "Phường",
                    value = user?.phuong ?: "",
                    onValueChange = onPhuongChange
                )
                // InputField cho Đường
                InputField(
                    label = "Đường",
                    value = user?.duong ?: "",
                    onValueChange = onDuongChange
                )
                // InputField cho Số nhà
                InputField(
                    label = "Số nhà",
                    value = user?.sonha ?: "",
                    onValueChange = onSoNhaChange
                )
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
                Text(
                    text = "Lưu",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable {
                        coroutineScope.launch {
                            val newUser = UserModel(
                                id = user?.id!!,
                                email = user?.email,
                                password = user?.password,
                                hoTen = hoTen,
                                soDienThoai = soDienThoai,
                                role = user?.role,
                                phuong = phuong,
                                duong = duong,
                                sonha = sonha
                            )

                            repositoryUser.updateUserById(newUser)

                            navController.popBackStack()
                        }
                    }
                )
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
            contentScale = ContentScale.Inside
        )
    }
}

