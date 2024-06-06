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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import coil.compose.AsyncImage
import com.example.com_tam.R
import com.example.com_tam.model.MonAnModel

@Preview(showBackground = true)
@Composable
fun XacNhanDonHang() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(58.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Cum tứm đim",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Divider(
                color = Color.Black,
                thickness = 3.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2F2D2D)
                    ),
                    modifier = Modifier
                        .width(174.dp)
                        .height(50.dp)
                        .background(Color(0xFF2F2D2D), shape = RoundedCornerShape(10.dp))
                ) {
                    Text(text = "Xác nhận", fontSize = 17.sp, color = Color.White)
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2F2D2D)
                    ),
                    modifier = Modifier
                        .width(174.dp)
                        .height(50.dp)
                        .background(Color(0xFF2F2D2D), shape = RoundedCornerShape(10.dp))
                ) {
                    Text(text = "Hủy", fontSize = 17.sp, color = Color.White)
                }
            }

            val mainDishes = listOf(
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                ),
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                ),
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                )
            )
            val additionalDishes = listOf(
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                ),
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                )
            )
            val toppings = listOf(
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                ),
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                )
            )
            val others = listOf(
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                ),
                MonAnModel(
                    1,
                    "Sườn bì",
                    56000.0f,
                    "https://images2.thanhnien.vn/528068263637045248/2023/7/20/base64-16898350173331230391375.png",
                    1
                )
            )

            //

            Spacer(modifier = Modifier.padding(15.dp))

            LazyColumn {
                item {
                    Text(
                        text = "Món chính",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))
                }

                itemsIndexed(mainDishes) { index, item ->
                    MenuItemRow(index = index, item = item)
                }

                item {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Divider(
                        color = Color(0xFFF1F2F3),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    // Additional Dishes Section
                    Text(
                        text = "Món phụ",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))
                }

                itemsIndexed(additionalDishes) { index, item ->
                    MenuItemRow(index = index, item = item)
                }

                item {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Divider(
                        color = Color(0xFFF1F2F3),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    // Additional Dishes Section
                    Text(
                        text = "Topping",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))
                }

                itemsIndexed(additionalDishes) { index, item ->
                    MenuItemRow(index = index, item = item)
                }

                item {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Divider(
                        color = Color(0xFFF1F2F3),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    // Additional Dishes Section
                    Text(
                        text = "Khác",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))
                }

                itemsIndexed(additionalDishes) { index, item ->
                    MenuItemRow(index = index, item = item)
                }

                item {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Divider(
                        color = Color(0xFFF1F2F3),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Số nhà: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "54",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Đường: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "14",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Phường: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Đông Hưng Thuận",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Quận: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "12",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Thành phố: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Hồ Chí Minh",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(15.dp))

                    // thanh toan

                    Divider(
                        color = Color.White,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Giờ: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "13h45p",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "SĐT: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "035923474",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tổng số lượng món ăn: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "2",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tổng số lượng món ăn thêm: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "2",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tổng số lượng Topping: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "2",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tổng số lượng khác: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "2",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Thành tiền: ",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "133k",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(20.dp))

                }
            }

        }

    }
}

@Composable
fun MenuItemRow(index: Int, item: MonAnModel) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2F2D2D)
        )
    ) {
        Row(
            modifier = Modifier.padding(15.dp)
        ) {

            Text(
                text = "${index + 1}",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            AsyncImage(
                model = item.hinhAnh,
                modifier = Modifier
                    .size(70.dp),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "${item.tenMon}", color = Color.White, fontSize = 18.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = item.giaBan.toString(), color = Color(0xFFFFA726), fontSize = 18.sp)
            }
            Text(
                text = "01",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        }
    }
}


