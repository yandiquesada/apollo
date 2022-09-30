package com.apollo

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.GravityCompat
import com.apollo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.product.presentation.list.ProductListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a Toolbar to replace the ActionBar.
        setSupportActionBar(binding.toolbar.toolbar)
        // This will display an Up icon (<-), we will replace it with hamburger later
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpDrawerContent(binding.navigationView)

        setupViews()
    }

    private fun setupViews() {
        drawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar.toolbar, R.string.drawer_open, R.string.drawer_close)
        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()

        // Tie DrawerLayout events to the ActionBarToggle
        binding.drawerLayout.addDrawerListener(drawerToggle)
    }

    // needed for hamburger animation
    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        drawerToggle.syncState()
    }

    // needed for hamburger animation
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    // handle actions in the toolbar = app bar = action bar
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_products -> {
            launchProductList()
            true
        }
        else -> {
            // handle action over the hamburger, open the drawer navigation view
            if (drawerToggle.onOptionsItemSelected(item)) {
                true
            } else {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setUpDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            onDrawerItemSelected(menuItem)
            // deselect the item by returning false
            false
        }
    }

    // handle actions in the drawer navigation view menu items
    private fun onDrawerItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.menu_item_products -> {
                launchProductList()
            }
        }

        // menuItem.isChecked = true
        binding.drawerLayout.closeDrawers()
    }

    private fun launchProductList() {
        // val productListIntent = Intent(this, ProductListActivity::class.java)
        val productListIntent = Intent(Intent.ACTION_VIEW)
        productListIntent.setData(Uri.parse("launch://products"))
        startActivity(productListIntent)
    }
}