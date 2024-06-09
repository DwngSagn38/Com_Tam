package com.example.com_tam.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4E1))
    ) {
        Header()
        OrderList()
    }
}

@Composable
fun Header() {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF252121))

    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text("Today: 19-05-2023", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold )
        Text("Số lượng đơn: 2", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        val revenueText = buildAnnotatedString {
            append("Doanh thu: ")
            withStyle(style = SpanStyle(color = Color(0xFFFFA500))) { // Màu cam
                append("320.000 đ")
            }
        }

        Text(text = revenueText, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun OrderList() {
    val orders = listOf(
        Order("CT2E22E", 162000, "Từ chối"),
        Order("CT2E206", 157000, "Từ chối"),
        Order("CT2E23E", 160000, "Chấp nhận"),
        Order("CT2E12E", 160000, "Chấp nhận")
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
                OrderItem(order)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun OrderItem(order: Order) {
    val statusColor = if (order.status == "Chấp nhận") Color.Green else Color.Red

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Đơn hàng ${order.id}",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${order.amount} đ",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Trạng thái",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = order.status,
                    color = statusColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class Order(val id: String, val amount: Int, val status: String)
