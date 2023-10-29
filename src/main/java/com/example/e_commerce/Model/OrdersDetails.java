package com.example.e_commerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double itemPrice;

    @ManyToOne
    private Product product;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Orders order;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private CartItem cartItem;
}
