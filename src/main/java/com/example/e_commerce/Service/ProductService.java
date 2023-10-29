package com.example.e_commerce.Service;

import com.example.e_commerce.Model.Product;

import java.util.List;

public interface ProductService {
    String addProduct(Product product);
    String deleteProduct(Long productId);
    String updateProduct(Long productId, Product product);
    Product getProductById(Long productId);
    Product getProductByName(String productName);
    List<Product> getAllProducts();

}
