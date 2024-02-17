package org.example;

public class Plateau
{
    private int[][] grille;
    private int joueurActuel;
    private boolean puissance4;

    public Plateau ()
    {
        this.grille = new int[6][7];
        this.joueurActuel = 1;
        this.puissance4 = false;
    }

    public boolean peuMettrePiece(int x)
    {
        return grille[0][x] == 0;
    }

    public void mettrePiece(int x)
    {
        boolean estJouer = false;

        for (int y = this.grille.length-1;y>=0 && !estJouer;y--)
        {
            if (this.grille[y][x] == 0)
            {
                this.grille[y][x] = this.joueurActuel;
                estJouer = true;

                if (verifFinDeGame(y,x))
                    this.puissance4 = true;

            }
        }

        prochainJoueur();
    }

    private void prochainJoueur()
    {
        this.joueurActuel = this.joueurActuel == 1 ? 2 : 1;
    }

    public boolean isPuissance4()
    {
        return this.puissance4;
    }
    private boolean verifFinDeGame(int ligne,int colonne)
    {
        boolean finDeGame = false;

        if (verifColonne(ligne,colonne) || verifLigne(ligne,colonne) || verifDiagonal(ligne,colonne))
            finDeGame = true;

        return finDeGame;
    }

    private boolean verifColonne(int ligne,int colonne)
    {
        boolean puissance = false;

        if (ligne < 3)
        {
            puissance = true;
            int player = this.grille[ligne][colonne];

            for (int i = ligne+1;i<ligne+4 && puissance;i++)
            {
                if (player != this.grille[i][colonne])
                    puissance = false;
            }
        }

        return puissance;
    }

    private boolean verifLigne(int ligne,int colonne)
    {
        int player = this.grille[ligne][colonne];
        boolean puissance = false;
        boolean obstaclePresent = false;
        int p4 = 1;

        for (int i = colonne-1;i>=0 && !puissance && !obstaclePresent;i--)
        {
            if (this.grille[ligne][i] == 0 || this.grille[ligne][i] != player)
            {
                obstaclePresent = true;
            }
            else
            {
                p4++;
            }

            if (p4 == 4)
                puissance = true;
        }

        obstaclePresent = false;

        for (int i = colonne+1;i<7 && !puissance && !obstaclePresent;i++)
        {
            if (this.grille[ligne][i] == 0 || this.grille[ligne][i] != player)
            {
                obstaclePresent = true;
            }
            else
            {
                p4++;
            }

            if (p4 == 4)
                puissance = true;
        }

        return puissance;
    }

    private boolean verifDiagonal(int ligne, int colonne)
    {
        boolean puissance = false;
        boolean obstaclePresent;

        int directionY,directionX;
        int y,x;
        int player = this.grille[ligne][colonne];
        int p4 = 1;

        int[][][] direction = {{{-1,1},{1,-1}},{{-1,-1},{1,1}}};


        for (int[][] diagonal : direction)
        {
            for (int[] d : diagonal)
            {
                directionY = d[0];
                directionX = d[1];
                obstaclePresent = false;

                y = ligne;
                x = colonne;

                for (int i = 0;i<4 && !obstaclePresent && !puissance;i++)
                {
                    y+=directionY;
                    x+=directionX;

                    if (y >= 0 && y <= 5 && x >= 0 && x <= 6)
                    {
                        if (this.grille[y][x] == player)
                            p4++;

                        if (p4 == 4)
                            puissance = true;
                    }
                    else
                    {
                        obstaclePresent = true;
                    }
                }
            }
            p4 = 1;
        }

        return puissance;
    }

    public void nouveauJeu()
    {
        for (int i = 0;i<this.grille.length;i++)
            for (int j = 0;j<this.grille[0].length;j++)
                grille[i][j] = 0;

        this.joueurActuel = 1;
        this.puissance4 = false;

    }


    public int[][] getGrille()
    {
        return this.grille;
    }
}
