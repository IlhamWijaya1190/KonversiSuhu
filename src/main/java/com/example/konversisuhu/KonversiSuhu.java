package com.example.konversisuhu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KonversiSuhu {
    private JFrame frame;
    private JTextField textField;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KonversiSuhu window = new KonversiSuhu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public KonversiSuhu() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame = new JFrame("Kalkulator Konverter Suhu");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        //OUTPUTAN
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(34, 131, 146, 16);
        frame.getContentPane().add(lblNewLabel);

        //INPUTAN
        textField = new JTextField();
        textField.setBounds(34, 36, 146, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        String[] temperatureScales = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox1 = new JComboBox<>(temperatureScales);
        comboBox1.setBounds(34, 89, 146, 26);
        frame.getContentPane().add(comboBox1);

        comboBox2 = new JComboBox<>(temperatureScales);
        comboBox2.setBounds(200, 89, 146, 26);
        frame.getContentPane().add(comboBox2);


        JButton btnNewButton = new JButton("Convert");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedScale1 = (String) comboBox1.getSelectedItem();
                String selectedScale2 = (String) comboBox2.getSelectedItem();
                double inputTemp = Double.parseDouble(textField.getText());
                double convertedTemp;

                if (selectedScale1.equals("Celsius") && inputTemp > 100) {
                    lblNewLabel.setText("Melebihi batas 100!°C");
                    return;
                }

                if (selectedScale1.equals("Fahrenheit") && inputTemp > 212) {
                    lblNewLabel.setText("Melebihi batas 212°F!");
                    return;
                }

                if (selectedScale1.equals("Kelvin") && inputTemp > 373.15) {
                    lblNewLabel.setText("Melebihi batas 373.15°K");
                    return;
                }

                if (selectedScale1.equals("Celsius")) {
                    if (selectedScale2.equals("Fahrenheit")) {
                        convertedTemp = (inputTemp * 9/5) + 32;
                    } else if (selectedScale2.equals("Kelvin")) {
                        convertedTemp = inputTemp + 273.15;
                    } else {
                        convertedTemp = inputTemp;
                    }
                } else if (selectedScale1.equals("Fahrenheit")) {
                    if (selectedScale2.equals("Celsius")) {
                        convertedTemp = (inputTemp - 32) * 5/9;
                    } else if (selectedScale2.equals("Kelvin")) {
                        convertedTemp = (inputTemp - 32) * 5/9 + 273.15;
                    } else {
                        convertedTemp = inputTemp;
                    }
                } else {
                    if (selectedScale2.equals("Celsius")) {
                        convertedTemp = inputTemp - 273.15;
                    } else if (selectedScale2.equals("Fahrenheit")) {
                        convertedTemp = (inputTemp - 273.15) * 9/5 + 32;
                    } else {
                        convertedTemp = inputTemp;
                    }
                }

                lblNewLabel.setText(String.format("%.2f", convertedTemp));
            }
        });
        btnNewButton.setBounds(34, 159, 117, 29);
        frame.getContentPane().add(btnNewButton);
    }
}
