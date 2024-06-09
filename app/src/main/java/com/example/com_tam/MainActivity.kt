package com.example.com_tam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.com_tam.database.DBHelper
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam.ui.theme.navigator.NavApp
import com.example.com_tam.ui.theme.screen.XacNhanDonHang
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var repositoryUser: RepositoryUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        repositoryUser = RepositoryUser(DBHelper.getInstance(this))
        CoroutineScope(Dispatchers.IO).launch {
            repositoryUser.populateDatabase(DBHelper.getInstance(this@MainActivity).userDAO())
        }

        setContent {
            NavApp()
        }
    }
}
