package com.example.com_tam.ui.theme.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.ui.theme.navigator.Screen

@Composable
fun ProfileScreen(navController: NavController) {
Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    horizontalAlignment =  Alignment.CenterHorizontally,
) {
    Text(text = "Hồ sơ",
        fontWeight = FontWeight(800),
        fontSize = 24.sp,
        color = Color.White,
        modifier = Modifier.padding(top = 70.dp)
    )
    
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 15.dp)
            .height(80.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Edit",
        fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.clickable {
                navController.navigate(
                    route = Screen.EditProfileScreen.route)
            }
            )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Signout",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.clickable {
                navController.navigate(
                    route = Screen.LoginScreen.route)
            })
    }
    
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(color = Color("#252121".toColorInt())),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp, 70.dp, 0.dp, 0.dp)
        ) {
            Text(text = "Van Anh",
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(label = "Số điện thoại", value = "", onValueChange = {})
            InputField(label = "Phường", value = "", onValueChange = {})
            InputField(label = "Đường", value = "", onValueChange = {})
            InputField(label = "Số nhà", value = "", onValueChange = {})
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
                .border(12.dp,Color.White, RoundedCornerShape(140.dp)),
            contentScale = ContentScale.Inside)
    }
}
@Composable
fun TextFeld(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
){
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
        )
    }
}
