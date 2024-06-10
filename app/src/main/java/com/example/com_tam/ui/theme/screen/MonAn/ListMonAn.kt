package com.example.com_tam.ui.theme.screen.MonAn

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.load
import coil.target.ImageViewTarget
import com.example.com_tam.R
import com.example.com_tam.model.LoaiMonAnModel
import com.example.com_tam.model.MonAnModel
import com.example.com_tam.ui.theme.component.HeaderQL
import com.example.com_tam.ui.theme.navigator.Screen
import com.example.com_tam.viewmodel.MonAnViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DanhSachMonAn(
    viewModel: MonAnViewModel,
    navController: NavController
){
    val context = LocalContext.current
    val monAns by viewModel.listMonAn.collectAsState(initial = emptyList())

    var idMonAn by remember {
        mutableStateOf(0)
    }

    var tenMon by remember {
        mutableStateOf("")
    }

    var giaBan by remember {
        mutableStateOf(0f)
    }

    var hinhAnh by remember {
        mutableStateOf("")
    }

    var idLoaiMon by remember {
        mutableStateOf(0)
    }

    var isShowdialogDelete by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 14.dp)
            .background(Color(0xFF252121))
    ) {
        HeaderQL(navController){
            navController.popBackStack()
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(monAns) {
                Card(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 6.dp),
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
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "" + it.id,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(5.dp),
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Image(painter = rememberImagePainter(it.hinhAnh), contentDescription = "",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(5.dp)),
                                contentScale = ContentScale.Crop)


                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = "" + it.tenMon,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                                Text(
                                    text = "" + it.giaBan,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color(0xFFFE724C)
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.width(120.dp)
                        ) {
                            Image(painter = painterResource(id = R.drawable.edit), contentDescription = "",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        navController.navigate(
                                            "${Screen.SuaMonAn.route}/" +
                                                    "${Uri.encode(it.id.toString())}/" +
                                                    "${Uri.encode(it.tenMon)}/" +
                                                    "${Uri.encode(it.giaBan.toString())}/" +
                                                    "${Uri.encode(it.hinhAnh)}/" +
                                                    "${Uri.encode(it.idLoaiMon.toString())}"
                                        )
                                    })
                            Image(painter = painterResource(id = R.drawable.delete), contentDescription = "",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        isShowdialogDelete = true
                                        idMonAn = it.id
                                        idLoaiMon = it.idLoaiMon!!
                                        tenMon = it.tenMon!!
                                        giaBan = it.giaBan!!
                                        hinhAnh = it.hinhAnh!!

                                    })
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }

                if (isShowdialogDelete) DialogConfirm(
                    monAnModel = MonAnModel(idMonAn,tenMon,giaBan,hinhAnh,idLoaiMon),
                    viewModel = viewModel,
                    onConfirm = { isShowdialogDelete = false },
                    context = context
                )

            }
        }
    }
}

@Composable
fun DialogConfirm(
    monAnModel: MonAnModel,
    viewModel: MonAnViewModel,
    onConfirm : () -> Unit,
    context: Context
){
    AlertDialog(onDismissRequest = { onConfirm() },
        dismissButton = {
                        Button(onClick = { onConfirm() }) {
                            Text(text = "No")
                        }
        },
        confirmButton = {
            Button(onClick = {
                onConfirm()
                viewModel.deleteMonAn(monAnModel)
                viewModel.listMonAn
                Toast.makeText(context,"Xoa thanh cong", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Yes")
            }
        },
        title = {
            Text(text = "Canh bao!")
        },
        text = {
            Text(text = "Ban co muon xoa khong?")
        })
}


