package com.example.directemail.service;

import com.example.directemail.model.Contact;
import com.example.directemail.model.ContactsWrapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

    public List<Contact> getAllFromCSV(String fileName) {
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

    public List<Contact> getAllFromXML(String fileName) {
        List<Contact> contacts = new ArrayList<>();

        try {
            URI uri = this.getClass().getResource("/" + fileName).toURI();
            File xmlFile = new File(uri);

            XmlMapper xmlMapper = new XmlMapper();
            ContactsWrapper contactsWrapper = xmlMapper.readValue(xmlFile, ContactsWrapper.class);
            contacts.addAll(contactsWrapper.getContacts());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler arquivo xml", e);
        }

        return contacts;
    }
}
