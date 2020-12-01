package model;

import view.Lavagna;
import view.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame(" LAVAGNA CON UNDO - Esempio Pattern Memento");
        f.setSize(new Dimension(800, 600));
        Lavagna lavagna = new Lavagna();
        TopPanel top = new TopPanel(lavagna);
        f.add(top, BorderLayout.PAGE_START);
        f.add(lavagna, BorderLayout.CENTER);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
