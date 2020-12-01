package view;

import memento.Caretaker;
import memento.Originator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Lavagna extends JPanel implements MouseMotionListener, MouseListener {

    private ArrayList<Punto> p;
    private Color color;
    Originator o = new Originator();
    Caretaker c = new Caretaker();
    JButton undoButton;

    public Lavagna(){
        p = new ArrayList<Punto>();
        undoButton = new JButton("UNDO");
        this.setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
        o.setOriginatorState(p);
        c.addMemento( o.createMemento() );
        addListeners();
        this.add(undoButton);
        System.out.println("Size stack inizio = " + c.saveState.size());

    }

    private void addListeners() {
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o.restore(c.popMemento());
                System.out.println("Size stack dopo undo = " + c.saveState.size());
                p.clear();
                for (int i = 0; i < o.getOriginatorState().size(); i++) {
                    p.add(o.getOriginatorState().get(i));
                }
                repaint();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Punto punto : p) {
            g.setColor(punto.c);
            g.fillOval(punto.x, punto.y, punto.dimension, punto.dimension);
        }
    }



    @Override
    public void mousePressed(MouseEvent e) {
        Punto p1 = new Punto(e.getX(), e.getY(), color);
        p.add(p1);
        repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Punto p1 = new Punto(e.getX(), e.getY(), color);
        p.add(p1);
        this.repaint();
        System.out.println("PREMUTO");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        o.setOriginatorState(p);
        c.addMemento( o.createMemento() );
        repaint();
        System.out.println("Size stack dopo inserimento = " + c.saveState.size());

    }




    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}




    public void setColor(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }
}
