package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.Product;
import com.example.e_commerce.Repo.ProductRepo;
import com.example.e_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepository;

    @Override
    public String addProduct(Product product) {
      productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }

    @Override
    public String updateProduct(Long productId, Product product) {
        Product product1 = productRepository.findById(productId).orElseThrow();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        productRepository.save(product1);

    return "Product updated successfully";}

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
