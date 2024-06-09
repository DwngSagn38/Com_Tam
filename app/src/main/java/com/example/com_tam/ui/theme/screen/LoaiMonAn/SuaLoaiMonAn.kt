package com.example.com_tam.ui.theme.screen.LoaiMonAn

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.com_tam.model.LoaiMonAnModel
import com.example.com_tam.ui.theme.navigator.TopAppBar
import com.example.com_tam.viewmodel.LoaiMonAnViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuaLoaiMonAn(viewModel: LoaiMonAnViewModel) {

    val showUpdateDialog = remember { mutableStateOf(false) }
    val emty by remember { mutableStateOf("") }
    var inputTenloai by remember { mutableStateOf("") }
    var inputidLoai by remember { mutableStateOf(0) }
    val loaiMons by viewModel.loaiMonAn.collectAsState(initial = emptyList())



    LazyColumn(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize(),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(loaiMons) {

            Card(
                onClick = {
                    inputidLoai =  it.id
                    inputTenloai = it.tenLoaiMon.toString()
                    showUpdateDialog.value = true
//                    navController.navigate("${ROUTE_NAME_SCREEN.Detail.name}/${ Uri.encode((it.uid.toString()))}/${Uri.encode(it.hoten)}/${Uri.encode(it.mssv)}/${Uri.encode(it.diemTB.toString())}/${Uri.encode(it.daratruong.toString())}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp)
                ) {
                    Text(
                        text = "" + it.id,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(5.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(10.dp) )
                    Text(
                        text = "Tên loại món: " + it.tenLoaiMon,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(5.dp),
                    )
                }
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
                                        Text(text = "Họ Tên")
                                    },
                                    placeholder = { Text(text = "Nhập Họ Tên")}
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}