package org.example;

import javax.swing.*;
import java.awt.*;

public class Grillage extends JComponent
{
    private final int LIGNE = 6;
    private final int COLONNE = 7;

    private Plateau plateau;
    private int[][] grille;


    private ListenerPlay listenerPlay;

    private int xCurseur;
    private int yCurseur;
    private Players joueur = Players.P1;

    public Grillage(Plateau plat)
    {
        this.plateau = plat;
        this.grille = plat.getGrille();
        this.listenerPlay = new ListenerPlay(this);


        addMouseListener(listenerPlay);
        addMouseMotionListener(listenerPlay);
    }


    public boolean peuMettre(int x)
    {
        return this.plateau.peuMettrePiece(x);
    }

    public void mettrePiece(int x)
    {
        this.plateau.mettrePiece(x);

        if (this.plateau.isPuissance4())
            this.plateau.nouveauJeu();

        repaint();
    }


    @Override
    public void paintComponent(Graphics g)
    {
        int x = 10;
        int y = 10;

        g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());

        g.setColor(Color.WHITE);

        for (int i=0;i<LIGNE;i++)
        {
            for (int j=0;j<COLONNE;j++)
            {
                g.fillOval(x,y,50,50);
                x+=60;
            }
            x=10;
            y+=60;
        }

        for (int i=0;i<LIGNE;i++)
        {
            for (int j=0;j<COLONNE;j++)
            {
                if (this.grille[i][j] == 1)
                {
                    g.setColor(Color.ORANGE);
                    g.fillOval(j*60+10,i*60+10,50,50);
                }
                else if (this.grille[i][j] == 2)
                {
                    g.setColor(Color.RED);
                    g.fillOval(j*60+10,i*60+10,50,50);
                }
            }
        }
        g.setColor(this.joueur.getCouleur());
        g.fillOval(this.xCurseur,this.yCurseur,20,20);
    }

    public void joueurSuivant()
    {
        this.joueur = this.joueur == Players.P1 ? Players.P2 : Players.P1;
    }

    public void setNewCoordonne(int x, int y)
    {
        this.xCurseur = x-5;
        this.yCurseur = y+2;
        repaint();
    }

}
