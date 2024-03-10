package com.example.directemailfactoryclient.service.xml;

import com.example.directemailfactorylib.model.Contact;
import com.example.directemailfactorylib.service.Contacts;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ContactsXML implements Contacts {

    private final String fileName;

    public ContactsXML(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Contact> getAll() {
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
