package com.product.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.product.presentation.R

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProductListFragment.newInstance())
                .commitNow()
        }
    }
}