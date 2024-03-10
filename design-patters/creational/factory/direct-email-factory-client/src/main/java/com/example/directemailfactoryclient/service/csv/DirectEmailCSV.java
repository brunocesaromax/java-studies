package com.example.directemailfactoryclient.service.csv;

import com.example.directemailfactorylib.service.Contacts;
import com.example.directemailfactorylib.service.DirectEmailService;

public class DirectEmailCSV extends DirectEmailService {

    private final String fileName;

    public DirectEmailCSV(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected Contacts createContacts() {
        return new ContactsCSV(fileName);
    }
}
