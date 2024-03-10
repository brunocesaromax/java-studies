package org.example;

import org.example.logfactoryclient.model.BankAccount;
import org.example.logfactoryclient.service.txt.LoggerTxt;
import org.example.logfactorylib.service.Logger;

import java.math.BigDecimal;

public class BankOperationTxt {

    public static void main(String[] args) {
        Logger logger = new LoggerTxt();

        var bankAccount = new BankAccount(logger, BigDecimal.valueOf(1000));

        bankAccount.deposit(BigDecimal.valueOf(500));
        bankAccount.withdraw(BigDecimal.valueOf(200));
    }
}