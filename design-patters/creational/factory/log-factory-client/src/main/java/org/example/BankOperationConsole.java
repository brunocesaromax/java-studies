package org.example;

import org.example.logfactoryclient.model.BankAccount;
import org.example.logfactoryclient.service.console.LoggerConsole;
import org.example.logfactorylib.service.Logger;

import java.math.BigDecimal;

public class BankOperationConsole {

    public static void main(String[] args) {
        Logger logger = new LoggerConsole();

        var bankAccount = new BankAccount(logger, BigDecimal.valueOf(1000));

        bankAccount.deposit(BigDecimal.valueOf(500));
        bankAccount.withdraw(BigDecimal.valueOf(200));
    }
}