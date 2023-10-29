package com.example.e_commerce.Repo;

import com.example.e_commerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.name = ?1")
    Product findByProductName(String productName);
}
