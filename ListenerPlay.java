package org.example;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ListenerPlay implements MouseListener, MouseMotionListener
{
    private  Rectangle[] rectangles;
    private Grillage grille;


    public ListenerPlay(Grillage grille)
    {
        this.grille = grille;
        this.rectangles = new Rectangle[7];
        int x = 20,y = 0;
        int d = 50;

        for (int i = 0;i<7;i++)
        {
            this.rectangles[i] = new Rectangle(x,d,y,d);
            x += d+10;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        for (int i = 0;i<this.rectangles.length;i++)
        {
            if (this.rectangles[i].estDansLeRectangle(x,y))
            {
                if (this.grille.peuMettre(i))
                {
                    this.grille.mettrePiece(i);
                    this.grille.joueurSuivant();
                }
            }
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) { grille.setNewCoordonne(e.getX(),e.getY()); }


    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e) {}

}
