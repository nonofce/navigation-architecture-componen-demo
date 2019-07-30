package com.nonofce.android.navigationcomponent

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main_with_drawer.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_with_drawer)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
        NavigationUI.setupWithNavController(navigation_view, navController)

        navigation_view.setNavigationItemSelectedListener {

            doNavigation(it)
            it.setChecked(true)
            drawer_layout.closeDrawers()
            true
        }

        bottom_nav?.let {
            NavigationUI.setupWithNavController(it, navController)
        }

        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

    }

    override fun onSupportNavigateUp(): Boolean = NavigationUI.navigateUp(navController, drawer_layout)

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_nav_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
        return navigated || super.onOptionsItemSelected(item)
    }

    private fun doNavigation(item: MenuItem) = navController.navigate(item.itemId)
}
