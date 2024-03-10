package com.example.directemailfactoryclient.service.xml;

import com.example.directemailfactorylib.service.Contacts;
import com.example.directemailfactorylib.service.DirectEmailService;

public class DirectEmailXML extends DirectEmailService {

    private final String fileName;

    public DirectEmailXML(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected Contacts createContacts() {
        return new ContactsXML(fileName);
    }
}
