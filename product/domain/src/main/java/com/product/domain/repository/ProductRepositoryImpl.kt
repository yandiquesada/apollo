package com.product.domain.repository

import com.product.domain.models.Product

class ProductRepositoryImpl {
     fun getProducts(): List<Product> {
        val productList = mutableListOf<Product>()

        var product = Product(
            title = "Factory Authorized Parts™ - AZ2280-1A-24A Relay",
            productNumber = "AZ2280-1A-24A",
            imageUrl = ""
        )
        productList.add(product)

        product = Product(
            title = "Carrier® Comfort™ - 2.5 Ton 14 SEER Residential Air Conditioner Condensing Unit",
            productNumber = "24ACC430A003",
            imageUrl = ""
        )
        productList.add(product)

        product = Product(
            title = "Carrier® Comfort™ - 3 Ton 14 SEER Residential Air Conditioner Condensing Unit",
            productNumber = "24ACC436A003",
            imageUrl = ""
        )
        productList.add(product)

        product = Product(
            title = "Carrier® Comfort™ - 2 Ton 14 SEER Residential Air Conditioner Condensing Unit",
            productNumber = "24ACC424A003",
            imageUrl = ""
        )
        productList.add(product)

        product = Product(
            title = "Carrier® Comfort™ - 3 Ton 16 SEER Residential Air Conditioner Condensing Unit",
            productNumber = "24ABC636A003",
            imageUrl = ""
        )
        productList.add(product)




        return productList
    }
}