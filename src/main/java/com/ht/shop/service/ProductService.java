package com.ht.shop.service;

import com.ht.shop.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    List<Product> findProductListByShopId(String shopId);

    int addProduct(Product product);

    int updateProduct(Product product);

    Product findProductByProductId(String productId);
}
