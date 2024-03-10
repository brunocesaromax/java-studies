package com.example.directemailfactoryclient;

import com.example.directemailfactoryclient.service.csv.DirectEmailCSV;
import com.example.directemailfactorylib.service.DirectEmailService;

import javax.swing.JOptionPane;

public class ClientRelationshipCSV {
    public static void main(String[] args) {
        DirectEmailService directEmailService = new DirectEmailCSV("contacts.csv");

        String msg = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");

        boolean status = directEmailService.send(msg);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);

    }
}