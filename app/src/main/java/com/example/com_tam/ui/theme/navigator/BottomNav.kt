package com.example.com_tam.ui.theme.navigator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.com_tam.ui.theme.screen.HomeScreen
import com.example.com_tam.ui.theme.screen.ProfileScreen
import com.example.com_tam.R
import com.example.com_tam.ui.theme.screen.HistoryScreen
import com.example.com_tam.ui.theme.screen.QuanLy
import com.example.com_tam.ui.theme.screen.StatisticsScreen
import com.example.com_tam.ui.theme.screen.XacNhanDonHang


// Bottom menu


enum class ROUTE_HOME_SCREEN {
    Home,
    XacNhanDh,
    Manager,
    Profile
}

@Composable
fun FurnitureApp(navHostController: NavController) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(
            ROUTE_HOME_SCREEN.Home.name,
            R.drawable.ic_home
        ),
        BottomNavigationItem(
            ROUTE_HOME_SCREEN.XacNhanDh.name,
            R.drawable.ic_lich_su
        ),
        BottomNavigationItem(
            ROUTE_HOME_SCREEN.Manager.name,
            R.drawable.ic_quan_ly
        ),
        BottomNavigationItem(
            ROUTE_HOME_SCREEN.Profile.name,
            R.drawable.ic_ho_so
        )
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(navController = navController, navHostController = navHostController)
            },
            bottomBar = {
                BottomNavigationBar(
                    items = items,
                    selectedItemIndex = selectedItemIndex,
                    onItemSelected = { index ->
                        selectedItemIndex = index
                        navController.navigate(items[index].title)
                    }
                )
            }
        ) { innerPadding ->
            NavigationGraph(navController = navController, navHostController = navHostController, innerPadding = innerPadding)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController, navHostController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "Home"
    val homeTitle = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),

                )
        ) {
            append("Cum tứm đim")
        }
    }

    val title: Any = when (currentRoute) {
        "Home" -> homeTitle
        "XacNhanDh" -> "Xác Nhận Đơn Hàng"
        "Manager" -> "Quản lý"
        "Profile" -> "Profile"
        else -> "Cơm tấm"
    }
    androidx.compose.material3.TopAppBar(
        title = {
            if (title is AnnotatedString) {
                Text(
                    text = title,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()
                )
            } else if (title is String) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
            }

        },
        actions = {
            if (currentRoute == "Home") {
                IconButton(onClick = { navHostController.navigate("cart") }) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }else {

                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0f), // Đặt alpha để làm trong suốt
                    modifier = Modifier.size(25.dp)
                )
            }
        },

        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(Color(0xFF252121)),

        )
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color(0xFF312C2C)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index) },
                icon = {
                    Image(
                        painter = painterResource(id = item.selectIcon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        colorFilter = if (selectedItemIndex == index) ColorFilter.tint(Color.Yellow) else ColorFilter.tint(
                            Color.White
                        )
                    )

                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selectedItemIndex == index) Color.Yellow else Color.White
                    )
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFF312C2C) // Không có màu con nhộng
                )


            )
        }
    }
}


data class BottomNavigationItem(
    val title: String,
    val selectIcon: Int

)

@Composable
fun NavigationGraph(navController: NavHostController, navHostController: NavController , innerPadding: PaddingValues) {
    NavHost(
        navController,
        startDestination = ROUTE_HOME_SCREEN.Home.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(ROUTE_HOME_SCREEN.Home.name) { HomeScreen() }
        composable(ROUTE_HOME_SCREEN.XacNhanDh.name) { XacNhanDonHang() }
        composable(ROUTE_HOME_SCREEN.Manager.name) { QuanLy(navHostController) }
        composable(ROUTE_HOME_SCREEN.Profile.name) { ProfileScreen() }
    }
}



