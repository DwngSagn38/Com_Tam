package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.com_tam.ui.theme.navigator.Screen

@Composable
fun HistoryScreen(navController: NavController) {
    OrderListScreen(navController)
}

@Composable
fun OrderListScreen(navController: NavController) {
    val orders = listOf(
        Order1(true, "10/03/2023", "9:20", 98.0, 3),
        Order1(false, "10/03/2023", "9:20", 98.0, 3),
        Order1(false, "10/03/2023", "9:20", 98.0, 3),
        Order1(true, "10/03/2023", "9:20", 98.0, 3),
        Order1(true, "10/03/2023", "9:20", 98.0, 3),
        Order1(false, "10/03/2023", "9:20", 98.0, 3),
        Order1(true, "10/03/2023", "9:20", 98.0, 3),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF252121))

        ) {
            items(orders) { order ->
                OrderItem(order, navController)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun OrderItem(order: Order1, navController: NavController) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray
        ),
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                       navController.navigate(Screen.XacNhanDHScreen.route)
            }
        ,
        shape = RoundedCornerShape(8.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = if (order.trangThai) "Đơn hàng đã chấp nhận" else "Đơn hàng đã bị hủy",
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${order.ngay}  ${order.thoiGian}",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
            Column {
                Text(
                    text = "${order.soLuong} món",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${order.giaTien}k",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

}

data class Order1(
    val trangThai: Boolean,
    val ngay: String,
    val thoiGian: String,
    val giaTien: Double,
    val soLuong: Int
)
