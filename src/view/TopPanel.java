package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {

    private JButton colorButton;

    public TopPanel(Lavagna lavagna) {
        setPreferredSize(new Dimension(800,40));
        colorButton = new JButton("Change color");
        //Choose layout
        this.setLayout(new GridLayout(1,3));
        this.add(colorButton);

        addListeners(lavagna);
    }

    private void addListeners(Lavagna lavagna){

        colorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a new color", lavagna.getColor());
                if(color != null) {
                    lavagna.setColor(color);
                }
            }
        });
    }
}
