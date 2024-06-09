package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.ui.theme.screen.LoaiMonAn.QuanLyLoaiMonAn
import com.example.com_tam.ui.theme.screen.MonAn.QuanLyMonAn

@Composable
fun QuanLy(navController: NavController) {
    var isQLLMA by remember{ mutableStateOf(false) }
    var isQLMA by remember{ mutableStateOf(false) }
    if (isQLMA) QuanLyMonAn(navController)
    else if (isQLLMA) QuanLyLoaiMonAn(navController)
    else Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.padding(18.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clickable {
                        isQLLMA = true
                        isQLMA = false
                    },
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(58.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Quản lý loại món ăn",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clickable {
                        isQLMA = true
                        isQLLMA = false
                    },
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(58.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Quản lý món ăn",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        }
    }
}