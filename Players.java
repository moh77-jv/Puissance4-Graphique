package org.example;

import java.awt.*;

public enum  Players
{
    P1(Color.ORANGE),
    P2(Color.RED);

    private Color couleur;

    Players(Color c)
    {
        this.couleur = c;
    }

    public Color getCouleur()
    {
        return this.couleur;
    }
}
