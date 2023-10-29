package com.example.e_commerce.Controller;

import com.example.e_commerce.Model.Product;
import com.example.e_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        String result = productService.addProduct(product);
        if (result != null) {
            return ResponseEntity.status(201).body("Product added with ID: " + result);
        } else {
            return ResponseEntity.badRequest().body("Failed to add product");
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        String deleted = productService.deleteProduct(productId);
        if (deleted != null) {
            return ResponseEntity.ok("Product deleted");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete product");
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        String updated = productService.updateProduct(productId, product);
        if (updated != null) {
            return ResponseEntity.ok("Product updated");
        } else {
            return ResponseEntity.badRequest().body("Failed to update product");
        }
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/name/{productName}")
    public Product getProductByName(@PathVariable String productName) {
        return productService.getProductByName(productName);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
