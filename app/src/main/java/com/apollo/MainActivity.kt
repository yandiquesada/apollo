package com.apollo

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.apollo.databinding.ActivityMainBinding
import com.product.presentation.list.ProductListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var buttonProductList: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        buttonProductList = binding.productList

        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        buttonProductList.setOnClickListener {
            // val productListIntent = Intent(this, ProductListActivity::class.java)
            val productListIntent = Intent(Intent.ACTION_VIEW)
            productListIntent.setData(Uri.parse("launch://products"))
            startActivity(productListIntent)
        }
    }
}