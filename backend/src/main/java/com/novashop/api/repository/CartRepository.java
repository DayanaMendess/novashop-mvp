package com.novashop.api.repository;

import com.novashop.api.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<Cart, Long> {
}
