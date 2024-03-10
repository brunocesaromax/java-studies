package com.example.saleorder.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private static final BigDecimal CUSTOMER_SPECIAL_DISCOUNT = BigDecimal.valueOf(0.96); //4%

    private String number;
    private Customer customer;
    private List<OrderItem> items;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalValue() {
        var totalValue = items.stream()
                .map(item -> item.getUnitValue().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        if (customer.isSpecial()) totalValue = totalValue.multiply(CUSTOMER_SPECIAL_DISCOUNT);

        return totalValue;
    }
}
