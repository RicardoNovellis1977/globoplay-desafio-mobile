package com.dino.globoplay

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dino.globoplay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val viewActionBar : View = layoutInflater.inflate(R.layout.actionbar_titletext,null)
        val params : ActionBar.LayoutParams = ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
        ActionBar.LayoutParams.MATCH_PARENT,Gravity.CENTER)
        supportActionBar?.apply {
            val textViewTitle: TextView = viewActionBar.findViewById(R.id.actionbar_textview)
            textViewTitle.text = getString(R.string.globoplay)
            setCustomView(viewActionBar,params)
            setDisplayShowCustomEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }
}