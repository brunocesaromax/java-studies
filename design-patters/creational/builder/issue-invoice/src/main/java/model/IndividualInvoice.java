package model;

import java.math.BigDecimal;

public class IndividualInvoice extends Invoice {

    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.07); //7%;

    @Override
    public BigDecimal getTaxValue() {
        return getTotalValue().multiply(TAX_RATE);
    }
}
