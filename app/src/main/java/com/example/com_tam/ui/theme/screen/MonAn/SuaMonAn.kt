package com.example.com_tam.ui.theme.screen.MonAn

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.com_tam.model.MonAnModel
import com.example.com_tam.ui.theme.component.HeaderQL
import com.example.com_tam.viewmodel.MonAnViewModel
import com.example.com_tam.viewmodel.isFloat

@Composable
fun SuaMonAn(
    navController: NavController,
    viewModel: MonAnViewModel,
    idMonAn : String?,
    tenMon : String,
    giaBan : String,
    hinhAnh : String,
    idLoaiMon : String
){
    val context = LocalContext.current

    var idLoaiMon by remember {
        mutableStateOf(idLoaiMon)
    }
    var giaBan by remember {
        mutableStateOf(giaBan)
    }
    var tenMon by remember {
        mutableStateOf(tenMon)
    }
    var onMsg by remember {
        mutableStateOf("")
    }

    // chon anh
    val selectedImageUri = remember { mutableStateOf<Uri?>(Uri.parse(hinhAnh)) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? ->
        selectedImageUri.value = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))
    ) {
        HeaderQL(navController){
            navController.popBackStack()
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(0.dp, 30.dp)
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            // Hiển thị hình ảnh đã chọn (nếu có)
            selectedImageUri.value?.let { imageUri ->
                Image(
                    painter = rememberImagePainter(imageUri),
                    contentDescription = "Selected Image",
                    modifier = Modifier
                        .size(250.dp, 250.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .clickable {
                            openImagePicker(context, imagePickerLauncher)
                        },
                    contentScale = ContentScale.Crop
                )
            }?: run{
                Column(
                    verticalArrangement = Arrangement.Center
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(250.dp, 250.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .clickable {
                            openImagePicker(context, imagePickerLauncher)
                        }
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    Text(text = "Thêm hình ảnh")
                }
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Ten mon an", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = ""+tenMon,
                onValueChange = { tenMon = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color("#E0E0E0".toColorInt()),
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Gia", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = ""+ giaBan,
                onValueChange = { giaBan = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color("#E0E0E0".toColorInt()),
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )



            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = {
                    if (!isFloat(giaBan)){
                        Toast.makeText(context,"Gia ban chua dung", Toast.LENGTH_SHORT).show()
                    }else{
                        val newMonAn = MonAnModel(idMonAn!!.toInt(),tenMon,giaBan.toFloat(), selectedImageUri.value.toString(), idLoaiMon.toInt() )
                        viewModel.updateMonAn(newMonAn)
                        navController.popBackStack()
                        viewModel.listMonAn
                        Toast.makeText(context,"Sua thanh cong", Toast.LENGTH_SHORT).show()
                    }
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFB703)
                    ),
                    modifier = Modifier.size(160.dp,40.dp)) {
                    Text(text = "Luu", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}