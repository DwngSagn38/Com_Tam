package com.example.com_tam.ui.theme.screen.LoaiMonAn

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.com_tam.R
import com.example.com_tam.model.LoaiMonAnModel
import com.example.com_tam.ui.theme.component.HeaderQL
import com.example.com_tam.ui.theme.navigator.Screen
import com.example.com_tam.ui.theme.navigator.TopAppBar
import com.example.com_tam.viewmodel.LoaiMonAnViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuaLoaiMonAn(viewModel: LoaiMonAnViewModel, navController: NavController) {

    val showUpdateDialog = remember { mutableStateOf(false) }
    val emty by remember { mutableStateOf("") }
    var inputTenloai by remember { mutableStateOf("") }
    var inputidLoai by remember { mutableStateOf(0) }
    val loaiMons by viewModel.loaiMonAns.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 14.dp)
            .background(Color(0xFF252121))
    ) {
        HeaderQL(navController){
            navController.popBackStack()
        }

        Row (
            modifier = Modifier
                .padding(start = 24.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Id",
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Name",
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(40.dp))
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(loaiMons) {

                Card(
                    onClick = {

//                    navController.navigate("${ROUTE_NAME_SCREEN.Detail.name}/${ Uri.encode((it.uid.toString()))}/${Uri.encode(it.hoten)}/${Uri.encode(it.mssv)}/${Uri.encode(it.diemTB.toString())}/${Uri.encode(it.daratruong.toString())}")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp,6.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(Color.DarkGray)

                ) {
                    Row(
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "" + it.id,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(5.dp),
                            color = Color.White
                        )
                        Text(
                            text = "" + it.tenLoaiMon,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(5.dp),
                            color = Color.White
                        )
                        Image(painter = painterResource(id = R.drawable.edit), contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    inputidLoai = it.id
                                    inputTenloai = it.tenLoaiMon.toString()
                                    showUpdateDialog.value = true
                                })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                if (showUpdateDialog.value) {
                    AlertDialog(
                        onDismissRequest = { showUpdateDialog.value = false },
                        dismissButton = {
                            Button(
                                onClick = {
                                    showUpdateDialog.value = false


                                }
                            ) {
                                Text(text = "Cancel")
                            }
                        },
                        confirmButton = {

                            Button(
                                onClick = {
                                    val newStudent = LoaiMonAnModel(inputidLoai!!.toInt(),inputTenloai)
                                    viewModel.updateLoaiMonAn(newStudent)
//                                    navController.popBackStack()
                                    showUpdateDialog.value = false
                                    inputTenloai = emty

                                }
                            ) {
                                Text(text = "Update")
                            }

                        },
                        title = {
                            Text(
                                text = "Update Loai mon an",
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                modifier = Modifier.padding(5.dp)
                            )
                        },
                        text = {
                            Column {
                                inputTenloai?.let { it1 ->
                                    OutlinedTextField(
                                        value = it1,
                                        onValueChange = {inputTenloai = it},
                                        label = {
                                            Text(text = "Tên loai mon an")
                                        },
                                        placeholder = { Text(text = "Nhập tên loai mon an")}
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}