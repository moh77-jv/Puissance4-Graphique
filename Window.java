package org.example;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame
{
    private final Dimension  DIMENSION = new Dimension(450,410);
    private Grillage grille;

    public Window()
    {
        super("Puissance 4");
        this.setLocation(500,100);
        this.setSize(DIMENSION);
        this.setMaximumSize(DIMENSION);
        this.setMinimumSize(DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.grille = new Grillage(new Plateau());
        this.add(grille);
    }
}
