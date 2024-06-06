package com.example.com_tam.ui.theme.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.com_tam.ui.theme.screen.HoTro
import com.example.com_tam.ui.theme.screen.QuanLy
import com.example.com_tam.ui.theme.screen.Welcome
import com.example.com_tam.ui.theme.screen.XacNhanDonHang

@Composable
fun NavApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route,
    ) {
        composable(Screen.Welcome.route) { Welcome() }
        composable(Screen.HoTroScreen.route) { HoTro() }
        composable(Screen.XacNhanDHScreen.route) { XacNhanDonHang() }
        composable(Screen.ManagerScreen.route) { QuanLy() }
    }
}