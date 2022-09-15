package com.product.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.product.domain.models.Product
import com.product.presentation.R
import com.product.presentation.databinding.ProductRowBinding

class ProductListAdapter(
    private val context: Context,
    private val productList: List<Product>
): RecyclerView.Adapter<ProductListAdapter.ProductItemViewHolder>() {

    private var _onRowTap = MutableLiveData<Boolean>()
    val onRowTap: MutableLiveData<Boolean> get() = _onRowTap

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductRowBinding.inflate(inflater)
        val view = binding.root

        return ProductItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val title: TextView
        private val productNumber: TextView
        private val productRowLayout: ConstraintLayout

        init {
            title = itemView.findViewById<TextView>(R.id.title)
            productNumber = itemView.findViewById<TextView>(R.id.product_number)
            productRowLayout = itemView.findViewById<ConstraintLayout>(R.id.product_row)
        }

        fun bind() {
            val product = productList.get(adapterPosition)
            title.text = product.title
            productNumber.text = product.productNumber

            productRowLayout.setOnClickListener {
                _onRowTap.value = true
            }
        }

    }
}