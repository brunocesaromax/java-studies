package com.example.directemailfactorylib.service;


import com.example.directemailfactorylib.model.Contact;

import java.util.List;

public abstract class DirectEmailService {

    //protected -> ser usado através da herança
    protected abstract Contacts createContacts();

    public boolean send(String msg) {
        List<Contact> contacts = createContacts().getAll();

        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem a ser enviada: " + msg);
        System.out.println();

        contacts.forEach(contact -> {
            System.out.println("From: <contact.root@email.com>");
            System.out.printf("To: [%s] <%s>\n", contact.getName(), contact.getEmail());
            System.out.println(msg);
            System.out.println();
        });

        return true;
    }
}
