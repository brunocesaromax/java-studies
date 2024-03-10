package org.example.logfactoryclient.model;

import org.example.logfactorylib.service.Logger;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class BankAccount {

    private final Logger logger;
    private final NumberFormat numberFormat;
    private BigDecimal balance;

    public BankAccount(Logger logger, BigDecimal balance) {
        this.logger = logger;
        Locale locale = new Locale("pt", "BR");
        numberFormat = NumberFormat.getCurrencyInstance(locale);
        this.balance = balance;

        logger.log("Saldo inicial da conta: " + numberFormat.format(this.balance));
    }

    public void deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
        logger.log("Novo saldo da conta após movimentação: " + numberFormat.format(this.balance));
    }

    public void withdraw(BigDecimal value) {
        if (balance.compareTo(value) < 0) {
            throw new RuntimeException("Operação em conta bancária inválida.");
        }

        this.balance = this.balance.subtract(value);
        logger.log("Novo saldo da conta após movimentação: " + numberFormat.format(this.balance));
    }
}
