package com.example.directemail;


import com.example.directemail.service.DirectEmailService;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        DirectEmailService directEmailService = new DirectEmailService();
        String msg = JOptionPane.showInputDialog(null, "Informe a mensagem para o e-mail");

        boolean status = directEmailService.send("contacts.xml", msg);
        System.out.println(status);
    }
}
