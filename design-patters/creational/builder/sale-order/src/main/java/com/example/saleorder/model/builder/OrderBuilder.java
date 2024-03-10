package com.example.saleorder.model.builder;

import com.example.saleorder.model.Customer;
import com.example.saleorder.model.Order;
import com.example.saleorder.model.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderBuilder {

    private final Order instance;

    public OrderBuilder() {
        instance = new Order();
    }

    public OrderBuilder withSpecialCustomer(String name) {
        buildCustomer(name, true);
        return this;
    }

    public OrderBuilder withNormalCustomer(String name) {
        buildCustomer(name, false);
        return this;
    }

    private void buildCustomer(String name, boolean special) {
        var customer = new Customer();
        customer.setName(name);
        customer.setSpecial(special);
        instance.setCustomer(customer);
    }

    public OrderBuilder withItem(String name, Integer quantity, BigDecimal unitValue) {
        var item = new OrderItem();
        item.setName(name);
        item.setQuantity(quantity);
        item.setUnitValue(unitValue);

        if (instance.getItems() == null) {
            instance.setItems(new ArrayList<>());
        }

        instance.getItems().add(item);

        return this;
    }

    public OrderBuilderValid withNumber(String number) {
        instance.setNumber(number);
        return new OrderBuilderValid(instance);
    }
}
