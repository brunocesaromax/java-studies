package com.example.directemailfactoryclient;

import com.example.directemailfactoryclient.service.xml.DirectEmailXML;
import com.example.directemailfactorylib.service.DirectEmailService;

import javax.swing.*;

public class ClientRelationshipXML {

    public static void main(String[] args) {
        DirectEmailService directEmailService = new DirectEmailXML("contacts.xml");

        String msg = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");

        boolean status = directEmailService.send(msg);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);

    }
}