package com.example.directemail.service;


import com.example.directemail.model.Contact;

import java.util.List;

public class DirectEmailService {

    public boolean send(String fileName, String msg) {
        ContactService contactService = new ContactService();
        List<Contact> contacts = contactService.getAllFromXML(fileName);

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
