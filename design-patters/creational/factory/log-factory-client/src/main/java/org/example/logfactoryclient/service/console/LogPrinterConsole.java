package org.example.logfactoryclient.service.console;

import org.example.logfactorylib.service.LogPrinter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogPrinterConsole implements LogPrinter {

    @Override
    public void print(String msg) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println(msg);
    }
}
