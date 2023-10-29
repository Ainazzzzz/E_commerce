package com.example.e_commerce.Service;

import com.example.e_commerce.Model.Cart;

import java.util.List;

public interface CartService {
    String addCart(Long userId,Cart cart);
    String deleteCart(Long cartId);
    Cart getCartByUserId(Long userId);
    Cart getCartById(Long cartId);
    List<Cart> getAllCarts();
    String updateCart(Long cartId, Long userId);
}
