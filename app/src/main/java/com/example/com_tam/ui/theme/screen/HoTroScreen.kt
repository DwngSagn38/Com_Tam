package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.com_tam.R

@Preview(showBackground = true)
@Composable
fun HoTro() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(15.dp))
                Image(
                    painter = painterResource(id = R.drawable.zalo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "0879175310",
                    fontSize = 19.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(15.dp))

                Image(
                    painter = painterResource(id = R.drawable.gmail),
                    contentDescription = null,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "vuthanhnam2102@gmail.com",
                    fontSize = 19.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(15.dp))

                Image(
                    painter = painterResource(id = R.drawable.dienthoai),
                    contentDescription = null,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "0879175310",
                    fontSize = 19.sp,
                    color = Color.White
                )
            }


        }
    }
}