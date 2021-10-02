package com.example.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fragmentdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navCon : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navCon = navHost.navController
        setupActionBarWithNavController(navCon)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navCon.navigateUp() || super.onSupportNavigateUp()
    }
}