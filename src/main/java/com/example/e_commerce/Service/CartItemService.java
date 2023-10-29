package com.example.e_commerce.Service;

import com.example.e_commerce.Model.CartItem;

import java.util.List;

public interface CartItemService {
    void deleteCartItem(Long cartItemId);
    String addCartItem(long orderDetailsId, CartItem cartItem);
    String updateCartItem(Long cartItemId, int quantity);
    List<CartItem> getCartItemsByUserId(Long userId);
    CartItem getCartItemById(Long cartItemId);
    List<CartItem> getCartItemsByCartId(Long cartId);


}
