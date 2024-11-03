package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private JPanel Root;
    private JButton btnConfirm;
    private JTextField tfName;
    private JTextField tfSurname;
    private JComboBox cbPosition;
    private JTextField tfLength;
    private JCheckBox chbLetterSize;
    private JCheckBox chbDigits;
    private JCheckBox chbSpecialChars;
    private JButton btnGenerate;
    private JPanel panForm;
    private JPanel panPassword;
    private JLabel labName;
    private JLabel labSurname;
    private JLabel labPosition;
    private JLabel labLength;

//    Password sets
    private final String setSLetters = "qwertyuiopasdfghjklzxcvbnm";
    private final String setBLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final String setDigits = "1234567890";
    private final String setSpecialChars = "!@#$%^&*()_+-=";

//    Data
    private String password = "";

    public Main() {
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int len;
                try {
                    len = Integer.parseInt(tfLength.getText());
                    if(len < 0)
                        throw new Exception();
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(Root, "Given length is not valid");
                    return;
                }
                Random random = new Random();
                password = "";
                if(chbLetterSize.isSelected() && password.length() < len)
                    password += setBLetters.charAt(random.nextInt(setBLetters.length()));
                if(chbDigits.isSelected() && password.length() < len)
                    password += setDigits.charAt(random.nextInt(setDigits.length()));
                if(chbSpecialChars.isSelected() && password.length() < len)
                    password += setSpecialChars.charAt(random.nextInt(setSpecialChars.length()));
                while (password.length() < len)
                    password += setSLetters.charAt(random.nextInt(setSLetters.length()));
                JOptionPane.showMessageDialog(Root, password);
            }
        });
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String surname = tfSurname.getText();
                String position = cbPosition.getSelectedItem().toString();
                JOptionPane.showMessageDialog(Root, "Dane pracownika: "+name+" "+surname+" "+position+" Hasło: "+password);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dodaj pracownika - XYZ");
        frame.setContentPane(new Main().Root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}