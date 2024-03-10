package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class Invoice {

    private String number;
    private Date issueDate;
    private List<ProductItem> productItemList;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public void setProductItemList(List<ProductItem> productItemList) {
        this.productItemList = productItemList;
    }

    public BigDecimal getTotalValue() {
        return getProductItemList().stream()
                .map(item -> item.getValue().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public abstract BigDecimal getTaxValue();
}
