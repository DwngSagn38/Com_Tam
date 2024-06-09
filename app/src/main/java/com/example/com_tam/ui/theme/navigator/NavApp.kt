package com.example.com_tam.ui.theme.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.com_tam.database.DBHelper
import com.example.com_tam.repository.RepositoryLoaiMon
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam.ui.theme.screen.EditProfileScreen
import com.example.com_tam.ui.theme.screen.HistoryScreen
import com.example.com_tam.ui.theme.screen.HoTro
import com.example.com_tam.ui.theme.screen.HomeScreen
import com.example.com_tam.ui.theme.screen.LoginScreen
import com.example.com_tam.ui.theme.screen.ProfileScreen
import com.example.com_tam.ui.theme.screen.QuanLy
import com.example.com_tam.ui.theme.screen.LoaiMonAn.QuanLyLoaiMonAn
import com.example.com_tam.ui.theme.screen.MonAn.AddMonAn
import com.example.com_tam.ui.theme.screen.LoaiMonAn.SuaLoaiMonAn
import com.example.com_tam.ui.theme.screen.LoaiMonAn.XoaLoaiMonAn
import com.example.com_tam.ui.theme.screen.MonAn.QuanLyMonAn
import com.example.com_tam.ui.theme.screen.Sign_inScreen
import com.example.com_tam.ui.theme.screen.StatisticsScreen
import com.example.com_tam.ui.theme.screen.WelcomeScreen
import com.example.com_tam.ui.theme.screen.XacNhanDonHang
import com.example.com_tam.viewmodel.LoaiMonAnViewModel

@Composable
fun NavApp() {
    val context = LocalContext.current
    val dbHelper = DBHelper.getInstance(context)
    val navController = rememberNavController()


    val repositoryLoaiMon = RepositoryLoaiMon(dbHelper)
    val LoaiMonViewModel = LoaiMonAnViewModel(repositoryLoaiMon)
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
        composable(Screen.ManagerScreen.route) { QuanLy(navController,dbHelper) }
        composable(Screen.HomeScreen.route) { HomeScreen() }
        composable(Screen.HistoryScreen.route) { HistoryScreen() }
        composable(Screen.ProfileScreen.route) { ProfileScreen(navController) }
        composable(Screen.EditProfileScreen.route) { EditProfileScreen(navController) }
        composable(Screen.StatisticScreen.route) { StatisticsScreen() }
        composable(Screen.FurnitureApp.route) { FurnitureApp(navController,dbHelper) }
        composable(Screen.QuanLyMonAn.route) { QuanLyMonAn(navController, dbHelper) }
        composable(Screen.QuanLyLoaiMonAn.route) { QuanLyLoaiMonAn(navController) }
        composable(Screen.AddMonAn.route) { AddMonAn(navController) }
        composable(Screen.SuaLoaiMonAn.route) { SuaLoaiMonAn(viewModel = LoaiMonViewModel) }
        composable(Screen.XoaLoaiMonAn.route) { XoaLoaiMonAn(viewModel = LoaiMonViewModel) }
    }
}