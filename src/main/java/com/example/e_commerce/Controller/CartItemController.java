package com.example.e_commerce.Controller;

import com.example.e_commerce.Model.CartItem;
import com.example.e_commerce.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cartItem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return ResponseEntity.ok("Cart item deleted");
    }

    @PostMapping
    public ResponseEntity<String> addCartItem(
            @RequestParam Long orderDetailsId, @RequestBody CartItem cartItem) {
        String result = cartItemService.addCartItem(orderDetailsId, cartItem);
        if (result != null) {
            return ResponseEntity.status(201).body("Cart item added with ID: " + result);
        } else {
            return ResponseEntity.badRequest().body("Failed to add cart item");
        }
    }


    @PutMapping("/{cartItemId}")
    public String  updateCartItem(@PathVariable Long cartItemId, @RequestParam int quantity) {
        return cartItemService.updateCartItem(cartItemId, quantity);
    }

    @GetMapping("/user/{userId}")
    public List<CartItem> getCartItemsByUserId(@PathVariable Long userId) {
        return cartItemService.getCartItemsByUserId(userId);
    }

    @GetMapping("/{cartItemId}")
    public CartItem getCartItemById(@PathVariable Long cartItemId) {
        return cartItemService.getCartItemById(cartItemId);
    }

    @GetMapping("/cart/{cartId}")
    public List<CartItem> getCartItemsByCartId(@PathVariable Long cartId) {
        return cartItemService.getCartItemsByCartId(cartId);
    }
}
