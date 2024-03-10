package org.example.logfactoryclient.service.txt;

import org.example.logfactorylib.service.LogPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogPrinterTxt implements LogPrinter {

    private final String fileName;

    public LogPrinterTxt() {
        this.fileName = "bank-account-transactions.txt";
    }

    @Override
    public void print(String msg) {
        var lines = Arrays.asList(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), msg);

        File file = new File(fileName);

        try {
            BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8));

            for (String line : lines) {
                buffWrite.append(line).append("\n");
            }

            buffWrite.close();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever mensagens de log no arquivo .txt");
        }
    }

}
