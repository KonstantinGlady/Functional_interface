package com.company.project2;

import javax.swing.*;
import java.awt.*;

public class ComputeSquare extends JFrame {

    JTextField number;
    JTextField square;
    JButton submit;
    JPanel panel;

    public ComputeSquare() {

        number = new JTextField(10);
        square = new JTextField(10);
        submit = new JButton("submit");

        submit.addActionListener((x) -> {
            try {
                int num = Integer.parseInt(number.getText());
                square.setText(Integer.toString(num * num));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " " + number.getText() + " is not number");
            }
        });

        panel = new JPanel();
        setSize(200, 300);
        panel.add(number);
        panel.add(square);
        panel.add(submit);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComputeSquare();
    }
}
