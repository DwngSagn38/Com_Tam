package com.example.com_tam.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.ui.theme.navigator.Screen

@Composable
fun HeaderQL(navController: NavController, onClickBack: () -> Unit){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFF252121))
            .padding(top = 20.dp)
    ){
        Spacer(modifier = Modifier.width(10.dp))

        Image(painter = painterResource(id = R.drawable.back), contentDescription = "",
            modifier = Modifier.size(15.dp)
                .clickable {
                    onClickBack()
                })
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp,52.dp)
                .clickable {
                    navController.navigate(Screen.ProfileScreen.route)
                }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Com tum dim",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }

    Divider(
        color = Color.Black, thickness = 4.dp
    )
}