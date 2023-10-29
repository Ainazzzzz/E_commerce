package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.Cart;
import com.example.e_commerce.Model.CartItem;
import com.example.e_commerce.Model.OrdersDetails;
import com.example.e_commerce.Model.Users;
import com.example.e_commerce.Repo.CartItemRepo;
import com.example.e_commerce.Repo.CartRepo;
import com.example.e_commerce.Repo.OrderDetailsRepo;
import com.example.e_commerce.Repo.UserRepo;
import com.example.e_commerce.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemsServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepo cartItemRepository;
    @Autowired
    private OrderDetailsRepo orderDetailsRepository;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private CartRepo cartRepository;


    @Override
    public void deleteCartItem(Long cartItemId) {
     cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public String addCartItem(long orderDetailsId, CartItem cartItem) {
        OrdersDetails orderDetails = orderDetailsRepository.findById(orderDetailsId).orElseThrow(() -> new RuntimeException("Order Details not found"));
        orderDetails.setCartItem(cartItem);
        cartItem.setOrdersDetails(orderDetails);
        cartItemRepository.save(cartItem);
        orderDetailsRepository.save(orderDetails);
        return "Cart Item added successfully";
    }

    @Override
    public String updateCartItem(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart Item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
        return "Cart Item updated successfully";
    }

    @Override
    public List<CartItem> getCartItemsByUserId(Long userId) {
       Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getCart().getCartItems();
    }

    @Override
    public CartItem getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart Item not found"));
    }

    @Override
    public List<CartItem> getCartItemsByCartId(Long cartId) {
     Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cart.getCartItems();
    }
}
