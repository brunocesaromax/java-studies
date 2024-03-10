package com.example.saleorder.test;

import com.example.saleorder.model.Customer;
import com.example.saleorder.model.Order;
import com.example.saleorder.model.OrderItem;
import com.example.saleorder.model.builder.OrderBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void mustCalculateOrderTotalValueToSpecialCustomer() {
        var order = new Order();

        var customer = new Customer();
        customer.setName("João");
        customer.setSpecial(true);
        order.setCustomer(customer);

        var item1 = new OrderItem();
        item1.setName("Calculadora");
        item1.setUnitValue(BigDecimal.valueOf(200));
        item1.setQuantity(2);

        var item2 = new OrderItem();
        item2.setName("Mochila");
        item2.setUnitValue(BigDecimal.valueOf(200));
        item2.setQuantity(1);

        var items = Arrays.asList(item1, item2);
        order.setItems(items);

        var totalValue = order.getTotalValue();

        assertEquals(BigDecimal.valueOf(576).doubleValue(), totalValue.doubleValue(), 0.0001); //0.0001 => error margin
    }

    @Test
    public void mustCalculateOrderTotalValueToSpecialCustomerWithBuilder() {
        // Construindo objeto para teste utilizando interface fluente
        var order  = new OrderBuilder()
                .withSpecialCustomer("João")
                .withItem("Calculadora", 2, BigDecimal.valueOf(200))
                .withItem("Mochila", 1, BigDecimal.valueOf(200))
                .withNumber("445566")
                .build();

        var totalValue = order.getTotalValue();

        assertEquals(BigDecimal.valueOf(576).doubleValue(), totalValue.doubleValue(), 0.0001); //0.0001 => error margin
    }
}
