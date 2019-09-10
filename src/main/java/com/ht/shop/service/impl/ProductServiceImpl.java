package com.ht.shop.service.impl;

import com.ht.shop.entity.Product;
import com.ht.shop.mapper.ProductMapper;
import com.ht.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<Product> findAllProduct() {
        return productMapper.selectAll();
    }

    public List<Product> findProductListByShopId(String shopId) {
        return productMapper.selectProductListByShopId(shopId);
    }

    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    public int updateProduct(Product product) {
        return productMapper.update(product);
    }

    public Product findProductByProductId(String productId) {
        return productMapper.selectProductByProductId(productId);
    }
}
