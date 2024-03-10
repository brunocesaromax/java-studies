package com.example.directemailfactoryclient.service.xml;

import com.example.directemailfactorylib.model.Contact;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class ContactsWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "contact")
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
