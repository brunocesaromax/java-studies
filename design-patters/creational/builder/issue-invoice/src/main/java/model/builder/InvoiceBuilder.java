package model.builder;

import model.IndividualInvoice;
import model.Invoice;
import model.LegalEntityInvoice;
import model.ProductItem;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceBuilder {

    private Invoice instance;

    public InvoiceBuilder constructIndividualInvoice() {
        instance = new IndividualInvoice();
        return this;
    }

    public InvoiceBuilder constructLegalEntityInvoice() {
        instance = new LegalEntityInvoice();
        return this;
    }

    public InvoiceBuilder withNumber(String number) {
        instance.setNumber(number);
        return this;
    }

    public InvoiceBuilder withIssueDate(Date issueDate) {
        instance.setIssueDate(issueDate);
        return this;
    }

    public InvoiceBuilder withIssueDate(String issueDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            instance.setIssueDate(sdf.parse(issueDate));
        } catch (ParseException e) {
            throw new RuntimeException("Não foi possível converter a data de emissão de nota fiscal de: string => data ", e);
        }

        return this;
    }

    public InvoiceBuilder withProductItem(String name, Integer quantity, String value) {
        return withProductItem(name, quantity, BigDecimal.valueOf(Double.parseDouble(value)));
    }

    public InvoiceBuilder withProductItem(String name, Integer quantity, Double value) {
        return withProductItem(name, quantity, BigDecimal.valueOf(value));
    }

    public InvoiceBuilder withProductItem(String name, Integer quantity, BigDecimal value) {
        var productItem = new ProductItem();
        productItem.setName(name);
        productItem.setQuantity(quantity);
        productItem.setValue(value);

        if (instance.getProductItemList() == null) {
            instance.setProductItemList(new ArrayList<>());
        }

        instance.getProductItemList().add(productItem);

        return this;
    }

    public Invoice build() {
        return instance;
    }

}
