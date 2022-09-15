package com.product.presentation.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.product.domain.repository.ProductRepositoryImpl
import com.product.presentation.R
import com.product.presentation.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment() {
    companion object {
        fun newInstance() = ProductListFragment()
    }

    private lateinit var viewBinding: ProductListFragmentBinding
    private lateinit var productListRecyclerView: RecyclerView
    private lateinit var viewModel: ProductListViewModel

    private var _onProductRowTap = MutableLiveData<Boolean>()
    val onProductRowTap: MutableLiveData<Boolean> get() = _onProductRowTap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = ProductListFragmentBinding.inflate(inflater)
        productListRecyclerView = viewBinding.products
        setupViews()

        return viewBinding.productList
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setupViews() {
        val productList = ProductRepositoryImpl().getProducts()

        // Recyclerview standard setup
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        productListRecyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(
            context,
            (layoutManager as LinearLayoutManager).orientation
        )
        productListRecyclerView.addItemDecoration(dividerItemDecoration)


        context?.let {
            val adapter = ProductListAdapter(it, productList)
            productListRecyclerView.adapter = adapter

            adapter.onRowTap.observe(viewLifecycleOwner) { onProductRowTap() }
        }
    }

    private fun onProductRowTap() {
        _onProductRowTap.value = true
    }
}