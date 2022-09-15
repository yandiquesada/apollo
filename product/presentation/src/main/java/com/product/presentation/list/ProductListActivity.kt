package com.product.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.product.presentation.R

class ProductListActivity : AppCompatActivity() {

    private lateinit var productListFragment: ProductListFragment
    private lateinit var productDetailsPageFragment: ProductDetailsPage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productListFragment = ProductListFragment.newInstance()
        productDetailsPageFragment = ProductDetailsPage.newInstance()

        setContentView(R.layout.product_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, productListFragment)
                .commit()
        }

        setUpObservables()
    }

    private fun setUpObservables() {
        productListFragment.onProductRowTap.observe(this){launchProductDetailsPage()}
    }

    private fun launchProductDetailsPage() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, productDetailsPageFragment)
            .addToBackStack(null)
            .commit()
    }
}