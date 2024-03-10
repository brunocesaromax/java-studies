package com.example.saleorder.model.builder;

import com.example.saleorder.model.Order;

public class OrderBuilderValid {

    private final Order instance;

    public OrderBuilderValid(Order instance) {
        this.instance = instance;
    }

    public Order build() {
        return instance;
    }
}
