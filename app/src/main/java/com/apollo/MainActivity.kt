package com.apollo

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.GravityCompat
import com.apollo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.product.presentation.list.ProductListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    // handle actions in the toolbar = app bar = action bar
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // The action bar home/up action should open or close the drawer.
        android.R.id.home -> {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            true
        }
        R.id.action_products -> {
            launchProductList()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun setUpDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            onDrawerItemSelected(menuItem)
            false
        }
    }

    // handle actions in the drawer menu items
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