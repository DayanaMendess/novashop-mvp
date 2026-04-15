package com.novashop.api.service;

import com.novashop.api.exception.BusinessException;
import com.novashop.api.exception.ResourceNotFoundException;
import com.novashop.api.model.*;
import com.novashop.api.repository.CartItemRepository;
import com.novashop.api.repository.OrderItemRepository;
import com.novashop.api.repository.OrderRepository;
import com.novashop.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final CartService cartService;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderService(CartService cartService,
                        CartItemRepository cartItemRepository,
                        OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        ProductRepository productRepository) {
        this.cartService = cartService;
        this.cartItemRepository = cartItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    public Order checkout(Long cartId) {
        Cart cart = cartService.findCart(cartId);

        if (cart.getStatus() == CartStatus.CHECKED_OUT) {
            throw new BusinessException("Este carrito ya fue confirmado");
        }

        List<CartItem> items = cartItemRepository.findByCartId(cartId);
        if (items.isEmpty()) {
            throw new BusinessException("No se puede confirmar un carrito vacío");
        }

        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new BusinessException("Stock insuficiente para el producto: " + product.getName());
            }
        }

        for (CartItem item : items) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }

        cart.setStatus(CartStatus.CHECKED_OUT);

        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setCart(cart);
        order.setTotal(cart.getSubtotal());
        order.setStatus(OrderStatus.CREATED);

        Order savedOrder = orderRepository.save(order);

        for (CartItem item : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProductId(item.getProduct().getId());
            orderItem.setProductName(item.getProduct().getName());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setUnitPrice(item.getUnitPrice());
            orderItem.setLineTotal(item.getLineTotal());
            orderItemRepository.save(orderItem);
        }

        cartService.recalculateSubtotal(cart);
        return savedOrder;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }
}
