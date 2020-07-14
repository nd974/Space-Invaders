import java.lang.Math;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Donnee
{
    /**Hauteur et Largeur de l'ecran du jeu */
    static int hauteurEcran = 70;
    static int largeurEcran = 120;

    /**Donnee sur les vie de diffrement objet */  
    static int vieAlien = 1;
    static int vieBoss = 20;
    static int vieVaisseau = 3;
    
    static int IDVaisseau = 1;
    static boolean VaisseauAmeliore = false; // possiblite de augmentation level -> vaisseau plus grans ou plsu rapide

    static int IDBoss = 10;
    static double deplacementAlien = 0.1;//vitesse et si >0 deplace a droite 
    static double deplacementBoss = 0.5;//vitesse et si >0 deplace a droite 
    static int stock_missile = 3;
    static int ItemCoeur = 0;
    static int ItemAmelioration = 1;
    
    static final int Boss = 10;// possiblite de mettre Boss1 ...
    
    static final int nombreALien = 3;
    static final int Alien1 = 0;
    static final int Alien2 = 1;
    static final int Alien3 = 2;

    static final int deplace = 5;
    static final int pointEliminationBoss = 100000;
    static final int pointEliminationAlien = 10000;
    static final int ScorePieceItem = 50000;
    static boolean nouvelle_vague = false;
    static int tempAmelioration;
}