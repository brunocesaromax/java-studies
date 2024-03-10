package com.example.directemailfactoryclient.service.csv;

import com.example.directemailfactorylib.model.Contact;
import com.example.directemailfactorylib.service.Contacts;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ContactsCSV implements Contacts {

    private final String fileName;

    public ContactsCSV(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            URI uri = this.getClass().getResource("/" + fileName).toURI();
            File csvFile = new File(uri);
            FileReader fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);

            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contacts.add(new Contact(nextLine[0].trim(), nextLine[1].trim()));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler arquivo csv", e);
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return contacts;
    }
}
