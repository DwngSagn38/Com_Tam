package com.example.com_tam.ui.theme.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.com_tam.database.DBHelper
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam.ui.theme.screen.EditProfileScreen
import com.example.com_tam.ui.theme.screen.HistoryScreen
import com.example.com_tam.ui.theme.screen.HoTro
import com.example.com_tam.ui.theme.screen.HomeScreen
import com.example.com_tam.ui.theme.screen.LoginScreen
import com.example.com_tam.ui.theme.screen.ProfileScreen
import com.example.com_tam.ui.theme.screen.QuanLy
import com.example.com_tam.ui.theme.screen.LoaiMonAn.QuanLyLoaiMonAn
import com.example.com_tam.ui.theme.screen.MonAn.QuanLyMonAn
import com.example.com_tam.ui.theme.screen.Sign_inScreen
import com.example.com_tam.ui.theme.screen.StatisticsScreen
import com.example.com_tam.ui.theme.screen.WelcomeScreen
import com.example.com_tam.ui.theme.screen.XacNhanDonHang

@Composable
fun NavApp() {
    val navController = rememberNavController()

    val dbHelper = DBHelper.getInstance(LocalContext.current)
    val repositoryUser = RepositoryUser(dbHelper)
    val userDao = dbHelper.userDAO()

    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
    ) {
        composable(Screen.WelcomeScreen.route) { WelcomeScreen(navController) }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController, repositoryUser)
        }
        composable(Screen.Sign_inScreen.route) {
            Sign_inScreen(navController, repositoryUser)
        }
        composable(Screen.HoTroScreen.route) { HoTro() }
        composable(Screen.XacNhanDHScreen.route) { XacNhanDonHang() }
        composable(Screen.ManagerScreen.route) { QuanLy(navController) }
        composable(Screen.HomeScreen.route) { HomeScreen() }
        composable(Screen.HistoryScreen.route) { HistoryScreen() }
        composable(Screen.ProfileScreen.route) { ProfileScreen(navController) }
        composable(Screen.EditProfileScreen.route) { EditProfileScreen(navController) }
        composable(Screen.StatisticScreen.route) { StatisticsScreen() }
        composable(Screen.FurnitureApp.route) { FurnitureApp(navController) }
        composable(Screen.QuanLyMonAn.route) { QuanLyMonAn(navController) }
        composable(Screen.QuanLyLoaiMonAn.route) { QuanLyLoaiMonAn(navController) }
    }
}