import model.builder.InvoiceBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {

    @Test
    void shouldCalculateTaxValueToIndividualInvoice() {
        var invoice = new InvoiceBuilder()
                .constructIndividualInvoice()
                .withNumber("1")
                .withIssueDate("25/12/2023")
                .withProductItem("Playstation 5", 1, "4500.00")
                .withProductItem("Pc Gamer", 1, "4000.00")
                .build();

        var taxValue = invoice.getTaxValue();

        assertEquals(BigDecimal.valueOf(595).doubleValue(), taxValue.doubleValue(), 0.0001); //0.0001 => error margin
    }

    @Test
    void shouldCalculateTaxValueToLegalEntityInvoice() {
        var invoice = new InvoiceBuilder()
                .constructLegalEntityInvoice()
                .withNumber("2")
                .withIssueDate("01/01/2024")
                .withProductItem("Playstation 5", 1, "4500.00")
                .withProductItem("Pc Gamer", 1, "4000.00")
                .build();

        var taxValue = invoice.getTaxValue();

        assertEquals(BigDecimal.valueOf(340).doubleValue(), taxValue.doubleValue(), 0.0001); //0.0001 => error margin
    }
}
