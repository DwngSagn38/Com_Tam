package com.example.com_tam.ui.theme.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.util.TableInfo
import com.example.com_tam.DAO.DBHelper
import com.example.com_tam.R
import com.example.com_tam.model.LoaiMonAnModel

@Composable
fun QlLoaiMonAn() {



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Divider(
                color = Color.Black,
                thickness = 3.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(18.dp))
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .clickable {
//                        showDialog = true
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
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
                        text = "Thêm loại món ăn",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
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
                        text = "SỬa loại mốn ăn",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Box(
                modifier = Modifier
                    .height(70.dp)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
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
                        text = "xóa loại món ăn",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.padding(30.dp))
            ListType()

        }
    }
}


@Composable
fun ListType(){
    val listCate = mutableListOf<LoaiMonAnModel>();
    listCate.add(LoaiMonAnModel(0,"com"))
    listCate.add(LoaiMonAnModel(1,"my"))
    listCate.add(LoaiMonAnModel(2,"phan"))
    listCate.add(LoaiMonAnModel(3,"Popular"))
    listCate.add(LoaiMonAnModel(4,"Popular"))
    listCate.add(LoaiMonAnModel(5,"Popular"))
    listCate.add(LoaiMonAnModel(6,"Popular"))
    listCate.add(LoaiMonAnModel(7,"Popular"))
    listCate.add(LoaiMonAnModel(8,"Popular"))
    listCate.add(LoaiMonAnModel(9,"Popular"))
    listCate.add(LoaiMonAnModel(10,"Popular"))
    listCate.add(LoaiMonAnModel(11,"Popular"))

    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                bottom = 15.dp,
                start = 20.dp
            )
            .verticalScroll(rememberScrollState())
    ){
        listCate.forEachIndexed { index, cate ->
            ItemRow(cate = cate, index = index)
        }
    }
}


@Composable
fun ItemRow(cate: LoaiMonAnModel, index: Int) {
    val selectedIndexes = remember { mutableStateListOf<Int>(0) }

    Column(
        modifier = Modifier
            .padding(end = 22.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,

            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(40.dp)
                .background(
                    color = if (index in selectedIndexes) Color(0xFF303030) else Color(0xFF303030),
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable {
                    if (index in selectedIndexes) {
                        selectedIndexes.remove(index)
                    } else {
                        selectedIndexes.add(index)
                    }
                }
                .fillMaxWidth()


        ) {
            cate.tenLoaiMon?.let {
                Text(
                    text = it,
                    color = if (index in selectedIndexes) {
                        Color(0xFFF5F5F5)
                    } else {
                        Color(0xFFF5F5F5)
                    },
                    fontSize = 19.sp,
                    fontWeight = if (index in selectedIndexes) {
                        FontWeight(600)
                    } else {
                        FontWeight(400)
                    },
                    modifier = Modifier.padding(start = 10.dp)

                )
            }
        }


    }
}

@Composable
fun getDialog(viewModel: DBHelper) {
    var inputTenLoaiMonAn by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val emty by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog= false },
            dismissButton = {
                            Button(onClick = {
                                showDialog = false
                                inputTenLoaiMonAn = emty
                            }) {
                                Text(text = "Cancel")
                            }
            },
            confirmButton = {
                if(inputTenLoaiMonAn.isNotEmpty()){
                    Button(onClick = {
                        viewModel.loaimonDAO().addLoaiMon(
                            LoaiMonAnModel(
                                0,
                                inputTenLoaiMonAn
                            )
                        )
                        showDialog = false
                        inputTenLoaiMonAn = emty
                    }) {
                        Text(text = "Save")
                    }
                }
            },
            title = {
                Text(text = "Them loai mon an",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp))
            },
            text = {
                Column {
                    OutlinedTextField(value = inputTenLoaiMonAn, onValueChange = {inputTenLoaiMonAn=it},
                        label = {
                            Text(text = "Ten loai mon")
                        },
                        placeholder = { Text(text = "Nhap ten loai mon")})
                }
            }
            )
    }
}
