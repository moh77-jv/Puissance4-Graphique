package org.example;

public class Rectangle
{
    private int x1,x2;
    private int y1,y2;

    public Rectangle(int x1,int l,int y1,int h)
    {
        this.x1 = x1;
        this.x2 = x1+l;

        this.y1 = y1;
        this.y2 = y1+h;
    }

    public boolean estDansLeRectangle(int x,int y)
    {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

}
