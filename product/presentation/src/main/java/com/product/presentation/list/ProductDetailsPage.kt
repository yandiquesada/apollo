package com.product.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.product.presentation.databinding.ProductDetailsPageBinding

class ProductDetailsPage: Fragment() {
    companion object {
        fun newInstance() = ProductDetailsPage()
    }

    private lateinit var viewBinding: ProductDetailsPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = ProductDetailsPageBinding.inflate(inflater)
        return viewBinding.productDetailsPage
    }

}
