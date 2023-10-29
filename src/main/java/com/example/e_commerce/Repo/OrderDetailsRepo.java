package com.example.e_commerce.Repo;

import com.example.e_commerce.Model.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrdersDetails,Long>{


}
