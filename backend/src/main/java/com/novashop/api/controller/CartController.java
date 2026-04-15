package com.novashop.api.controller;

import com.novashop.api.dto.AddCartItemRequest;
import com.novashop.api.dto.CreateCartRequest;
import com.novashop.api.dto.UpdateCartItemRequest;
import com.novashop.api.model.Cart;
import com.novashop.api.model.CartItem;
import com.novashop.api.service.CartService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart create(@Valid @RequestBody CreateCartRequest request) {
        return cartService.create(request);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getCart(@PathVariable Long id) {
        return cartService.getCartDetails(id);
    }

    @PostMapping("/{cartId}/items")
    public CartItem addItem(@PathVariable Long cartId, @Valid @RequestBody AddCartItemRequest request) {
        return cartService.addItem(cartId, request);
    }

    @PutMapping("/{cartId}/items/{itemId}")
    public CartItem updateItem(@PathVariable Long cartId,
                               @PathVariable Long itemId,
                               @Valid @RequestBody UpdateCartItemRequest request) {
        return cartService.updateItem(cartId, itemId, request);
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public void deleteItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        cartService.deleteItem(cartId, itemId);
    }
}
