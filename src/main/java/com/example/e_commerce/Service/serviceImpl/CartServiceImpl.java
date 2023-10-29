package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.Cart;
import com.example.e_commerce.Model.Users;
import com.example.e_commerce.Repo.CartRepo;
import com.example.e_commerce.Repo.UserRepo;
import com.example.e_commerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepository;
    @Autowired
    private UserRepo userRepository;


    @Override
    public String addCart(Long userId,Cart cart) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setCart(cart);
        cartRepository.save(cart);
        userRepository.save(user);
        return "Cart added successfully";
    }

    @Override
    public String deleteCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Users user = userRepository.findById(cart.getUsers().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setCart(null);
        userRepository.save(user);
        cartRepository.deleteById(cartId);
        return "Cart deleted successfully";
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getCart();
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public String updateCart(Long cartId, Long userId) {
        return null;
    }
}
