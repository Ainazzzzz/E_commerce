package com.example.e_commerce.Controller;

import com.example.e_commerce.Model.Cart;
import com.example.e_commerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<String> addCart(@RequestParam Long userId, @RequestBody Cart cart) {
        String result = cartService.addCart(userId, cart);
        if (result != null) {
            return ResponseEntity.status(201).body("Cart added with ID: " + result);
        } else {
            return ResponseEntity.badRequest().body("Failed to add cart");
        }
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.ok("Cart deleted");
    }

    @GetMapping("/user/{userId}")
    public Cart getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PutMapping("/{cartId}")
    public String updateCart(@PathVariable Long cartId, @RequestParam Long userId) {
      return cartService.updateCart(cartId, userId);
    }
}
