package model;

import java.math.BigDecimal;

public class LegalEntityInvoice extends Invoice {

    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.04); //4%;


    @Override
    public BigDecimal getTaxValue() {
        return getTotalValue().multiply(TAX_RATE);
    }
}
