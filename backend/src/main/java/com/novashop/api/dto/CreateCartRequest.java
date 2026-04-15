package com.novashop.api.dto;

import jakarta.validation.constraints.NotNull;

public class CreateCartRequest {
    @NotNull
    private Long customerId;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
