package com.novashop.api.service;

import com.novashop.api.dto.AddCartItemRequest;
import com.novashop.api.dto.CreateCartRequest;
import com.novashop.api.dto.UpdateCartItemRequest;
import com.novashop.api.exception.BusinessException;
import com.novashop.api.exception.ResourceNotFoundException;
import com.novashop.api.model.*;
import com.novashop.api.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository,
                       CustomerRepository customerRepository,
                       ProductRepository productRepository,
                       CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart create(CreateCartRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setStatus(CartStatus.OPEN);
        cart.setSubtotal(BigDecimal.ZERO);

        return cartRepository.save(cart);
    }

    public Map<String, Object> getCartDetails(Long cartId) {
        Cart cart = findCart(cartId);
        List<CartItem> items = cartItemRepository.findByCartId(cartId);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("cart", cart);
        response.put("items", items);
        return response;
    }

    public CartItem addItem(Long cartId, AddCartItemRequest request) {
        Cart cart = findCart(cartId);
        validateCartOpen(cart);

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        if (product.getStock() < request.getQuantity()) {
            throw new BusinessException("Stock insuficiente");
        }

        CartItem item = cartItemRepository.findByCartIdAndProductId(cartId, product.getId())
                .orElseGet(CartItem::new);

        int quantity = request.getQuantity();
        if (item.getId() != null) {
            quantity = item.getQuantity() + request.getQuantity();
            if (product.getStock() < quantity) {
                throw new BusinessException("Stock insuficiente para actualizar la cantidad");
            }
        }

        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setUnitPrice(product.getPrice());
        item.setLineTotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        CartItem saved = cartItemRepository.save(item);
        recalculateSubtotal(cart);
        return saved;
    }

    public CartItem updateItem(Long cartId, Long itemId, UpdateCartItemRequest request) {
        Cart cart = findCart(cartId);
        validateCartOpen(cart);

        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item no encontrado"));

        if (!item.getCart().getId().equals(cartId)) {
            throw new BusinessException("El item no pertenece al carrito indicado");
        }

        if (item.getProduct().getStock() < request.getQuantity()) {
            throw new BusinessException("Stock insuficiente");
        }

        item.setQuantity(request.getQuantity());
        item.setLineTotal(item.getUnitPrice().multiply(BigDecimal.valueOf(request.getQuantity())));

        CartItem saved = cartItemRepository.save(item);
        recalculateSubtotal(cart);
        return saved;
    }

    public void deleteItem(Long cartId, Long itemId) {
        Cart cart = findCart(cartId);
        validateCartOpen(cart);

        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item no encontrado"));

        if (!item.getCart().getId().equals(cartId)) {
            throw new BusinessException("El item no pertenece al carrito indicado");
        }

        cartItemRepository.delete(item);
        recalculateSubtotal(cart);
    }

    public List<CartItem> getItems(Long cartId) {
        findCart(cartId);
        return cartItemRepository.findByCartId(cartId);
    }

    public Cart findCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado"));
    }

    public void recalculateSubtotal(Cart cart) {
        List<CartItem> items = cartItemRepository.findByCartId(cart.getId());
        BigDecimal subtotal = items.stream()
                .map(CartItem::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setSubtotal(subtotal);
        cartRepository.save(cart);
    }

    private void validateCartOpen(Cart cart) {
        if (cart.getStatus() != CartStatus.OPEN) {
            throw new BusinessException("El carrito ya fue cerrado");
        }
    }
}
