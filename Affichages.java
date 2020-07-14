import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.lang.model.util.ElementScanner6;

public class Affichages
{
    public static EnsembleChaines afficheGAMEOVER(EnsembleChaines ens, Score score)
    {
        ens.ajouteChaine(Donnee.hauteurEcran/4,(Donnee.largeurEcran/3)+2," ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ");
        ens.ajouteChaine(Donnee.hauteurEcran/4,(Donnee.largeurEcran/3)+1,"██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
        ens.ajouteChaine(Donnee.hauteurEcran/4,Donnee.largeurEcran/3,    "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
        ens.ajouteChaine(Donnee.hauteurEcran/4,(Donnee.largeurEcran/3)-1,"██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
        ens.ajouteChaine(Donnee.hauteurEcran/4,(Donnee.largeurEcran/3)-2,"╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
        ens.ajouteChaine(Donnee.hauteurEcran/4,(Donnee.largeurEcran/3)-3," ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═");
        ens.ajouteChaine(Donnee.hauteurEcran/2,Donnee.hauteurEcran/4,"SCORE :"+score.getScore());
        ens.ajouteChaine(Donnee.hauteurEcran/2,Donnee.hauteurEcran/5,"appuiez sur Entree pour rejouer");
        return ens;
    }

    public static EnsembleChaines afficheScore(EnsembleChaines ens, int score)
    {
        String scoreDeci = new DecimalFormat("0000000000").format(score);
        ens.ajouteChaine(Donnee.largeurEcran/12,Donnee.hauteurEcran-3,"SCORE\n"+scoreDeci);
        return ens;
    }

    public static EnsembleChaines afficheBestHighScore(EnsembleChaines ens,ArrayList<Integer> liste)
    {
        String bestscore = new DecimalFormat("0000000000").format(Collections.max(liste));  
        ens.ajouteChaine(Donnee.largeurEcran-20,Donnee.hauteurEcran-3,"SCORE\n"+bestscore);
        return ens;
    }

    public static EnsembleChaines afficheHighScoreNull(EnsembleChaines ens)
    {
        String bestscore = new DecimalFormat("0000000000").format(0);  
        ens.ajouteChaine(Donnee.largeurEcran-20,Donnee.hauteurEcran-3,"HIGH SCORE\n"+bestscore);
        return ens;
    }

    public static EnsembleChaines afficheLimitation(EnsembleChaines ens)
    {
        String limitation = "";
        for (int i = 0;i<Donnee.largeurEcran;i++)
        {
            limitation+="_";
        }
        ens.ajouteChaine(0,Donnee.hauteurEcran-5,limitation);
        return ens;
    }

    public static EnsembleChaines afficheViesVaisseau(EnsembleChaines ens, int vie)
    {
        int largeurEcranVariante = Donnee.largeurEcran/4;
        for (int i = 0;i<vie;i++)
        {
            ens.ajouteChaine(largeurEcranVariante, Donnee.hauteurEcran-2, "▄██▄██▄");
            ens.ajouteChaine(largeurEcranVariante, Donnee.hauteurEcran-3, "▀█████▀");
            ens.ajouteChaine(largeurEcranVariante, Donnee.hauteurEcran-4, "  ▀█▀");
            largeurEcranVariante += Donnee.largeurEcran/15;
        }
        return ens;
    }

    public static EnsembleChaines afficheItemsAmelioration(EnsembleChaines ens)
    {
        ens.ajouteChaine((Donnee.largeurEcran/2), Donnee.hauteurEcran  , " ___");
        ens.ajouteChaine((Donnee.largeurEcran/2), Donnee.hauteurEcran-1, "|__ \\ ");
        ens.ajouteChaine((Donnee.largeurEcran/2), Donnee.hauteurEcran-2, "   ) |");
        ens.ajouteChaine((Donnee.largeurEcran/2), Donnee.hauteurEcran-3, "  / /");
        ens.ajouteChaine((Donnee.largeurEcran/2), Donnee.hauteurEcran-4, " |_|");
        ens.ajouteChaine((Donnee.largeurEcran/2), Donnee.hauteurEcran-5, " (_)");
        return ens;
    }

    public static EnsembleChaines afficheVaisseau(EnsembleChaines ens, double posx)
    {
        if (Donnee.VaisseauAmeliore)
        {
            ens.ajouteChaine((int)posx,5,"      ||");
            ens.ajouteChaine((int)posx,4,"      ||");
            ens.ajouteChaine((int)posx,3,"      ||");
            ens.ajouteChaine((int)posx,2,"     ████");
            ens.ajouteChaine((int)posx,1,"▄████████████▄");
            ens.ajouteChaine((int)posx,0,"██████████████");
        }
        else
        {
            ens.ajouteChaine((int)posx,3,"      ▄");
            ens.ajouteChaine((int)posx,2,"     ███");
            ens.ajouteChaine((int)posx,1,"▄███████████▄");
            ens.ajouteChaine((int)posx,0,"█████████████");
        }
        return ens;
    }

    public static EnsembleChaines afficheStockVaisseau(EnsembleChaines ens)
    {
        int largeurEcranVariante = (Donnee.largeurEcran/2)+(Donnee.largeurEcran/10);
        for (int i = 1;i<=Donnee.stock_missile;i++)
        {
            if (Donnee.VaisseauAmeliore)
            {
                ens.ajouteChaine(largeurEcranVariante,Donnee.hauteurEcran-1," ◢◣");
                ens.ajouteChaine(largeurEcranVariante,Donnee.hauteurEcran-2," ██");
                ens.ajouteChaine(largeurEcranVariante,Donnee.hauteurEcran-3," ██");
                ens.ajouteChaine(largeurEcranVariante,Donnee.hauteurEcran-4,"◢██◣");
            }

            else
            {
                ens.ajouteChaine(largeurEcranVariante,Donnee.hauteurEcran-2," ◢◣");
                ens.ajouteChaine(largeurEcranVariante,Donnee.hauteurEcran-3,"◢██◣");
            }
            largeurEcranVariante += Donnee.largeurEcran/25;
        }
        return ens;
    }

    public static EnsembleChaines afficheItemstockVaisseau(EnsembleChaines ens, double posx, double posy ,int rand)
    {
        if (rand == Donnee.ItemCoeur)
        {
            ens.ajouteChaine((int)posx,(int)posy+2,"▄██▄██▄");
            ens.ajouteChaine((int)posx,(int)posy+1,"▀█████▀");
            ens.ajouteChaine((int)posx,(int)posy  ,"  ▀█▀");
        }   

        else if (rand == Donnee.ItemAmelioration)
        {
            ens.ajouteChaine((int)posx,(int)posy+5," ___");
            ens.ajouteChaine((int)posx,(int)posy+4,"|__ \\ ");
            ens.ajouteChaine((int)posx,(int)posy+3,"   ) |");
            ens.ajouteChaine((int)posx,(int)posy+2,"  / /");
            ens.ajouteChaine((int)posx,(int)posy+1  ," |_|");
            ens.ajouteChaine((int)posx,(int)posy  ," (_)");
        }
        
        else if (rand%2==0 && rand != Donnee.ItemCoeur)
        {
            ens.ajouteChaine((int)posx,(int)posy+4,"   ████");
            ens.ajouteChaine((int)posx,(int)posy+3," ███  ███");
            ens.ajouteChaine((int)posx,(int)posy+2,"████  ████");
            ens.ajouteChaine((int)posx,(int)posy+1," ███  ███");
            ens.ajouteChaine((int)posx,(int)posy  ,"   ████");
        }
          
        else
        {
            ens.ajouteChaine((int)posx,(int)posy+4,  "       ,*");
            ens.ajouteChaine((int)posx,(int)posy+3,"   __ / ");
            ens.ajouteChaine((int)posx,(int)posy+2," ▄████▄ ");
            ens.ajouteChaine((int)posx,(int)posy+1,"|██████|");
            ens.ajouteChaine((int)posx,(int)posy  ," ▀████▀ ");
        }   
        return ens;
    }

    public static EnsembleChaines afficheProjectile(EnsembleChaines ens, double posx, double posy, int type)
    {
        if (type==Donnee.Boss)
        {
            ens.ajouteChaine((int)posx,(int)posy  ,"|\\**/|");
            ens.ajouteChaine((int)posx,(int)posy-1,"\\ == /");
            ens.ajouteChaine((int)posx,(int)posy-2," |  |");
            ens.ajouteChaine((int)posx,(int)posy-3," |  |");
            ens.ajouteChaine((int)posx,(int)posy-4," \\  /");
            ens.ajouteChaine((int)posx,(int)posy-5,"  \\/");
        }
        else
        {
            if (Donnee.VaisseauAmeliore)
            {
                ens.ajouteChaine((int)posx,(int)posy+3," ◢◣");
                ens.ajouteChaine((int)posx,(int)posy+2," ██");
                ens.ajouteChaine((int)posx,(int)posy+1," ██");
                ens.ajouteChaine((int)posx,(int)posy,  "◢██◣");
            }

            else
            {
                ens.ajouteChaine((int)posx,(int)posy+1, " ◢◣");
                ens.ajouteChaine((int)posx,(int)posy  , "◢██◣");
            }
            
        } 
        return ens;
    }

    public static EnsembleChaines afficheAlien1(EnsembleChaines ens, double posx, double posy)
    {
        if ((int)posx%3==0)
        {
        ens.ajouteChaine((int)posx,(int)posy,  "  ▀▄   ▄▀  ");
        ens.ajouteChaine((int)posx,(int)posy-1," ▄█▀███▀█▄ ");
        ens.ajouteChaine((int)posx,(int)posy-2,"█▀███████▀█");
        ens.ajouteChaine((int)posx,(int)posy-3,"█ █▀▀▀▀▀█ █");
        ens.ajouteChaine((int)posx,(int)posy-4,"   ▀▀ ▀▀   ");
        }
        else if ((int)posx%2==0)
        {
        ens.ajouteChaine((int)posx,(int)posy,  "  ▀▄   ▄▀");
        ens.ajouteChaine((int)posx,(int)posy-1," ▄█▀███▀█▄");
        ens.ajouteChaine((int)posx,(int)posy-2,"█▀███████▀█");
        ens.ajouteChaine((int)posx,(int)posy-3,"█ █▀▀▀▀▀█ █");
        ens.ajouteChaine((int)posx,(int)posy-4," ▀▀     ▀▀");
        }
        else
        {
        ens.ajouteChaine((int)posx,(int)posy,  "  ▀▄   ▄▀");
        ens.ajouteChaine((int)posx,(int)posy-1," ▄█▀███▀█▄");
        ens.ajouteChaine((int)posx,(int)posy-2,"█▀███████▀█");
        ens.ajouteChaine((int)posx,(int)posy-3,"█ █▀▀▀▀▀█ █");
        ens.ajouteChaine((int)posx,(int)posy-4,"▀▀       ▀▀"); 
        }
        return ens;
    }

    public static EnsembleChaines afficheAlien2(EnsembleChaines ens, double posx, double posy)
    {
        if ((int)posx%3==0)
        {
            ens.ajouteChaine((int)posx,(int)posy,  "   ▄██▄");
            ens.ajouteChaine((int)posx,(int)posy-1," ▄██████▄");
            ens.ajouteChaine((int)posx,(int)posy-2,"███▄██▄███");
            ens.ajouteChaine((int)posx,(int)posy-3,"  ▄▀▄▄▀▄");
            ens.ajouteChaine((int)posx,(int)posy-4," ▀ ▀  ▀ ▀");
        }
        else if ((int)posx%2==0)
        {
            ens.ajouteChaine((int)posx,(int)posy,  "  ▄██▄");
            ens.ajouteChaine((int)posx,(int)posy-1," ▄██████▄");
            ens.ajouteChaine((int)posx,(int)posy-2,"████▄█▄███");
            ens.ajouteChaine((int)posx,(int)posy-3,"  ▄▀▄▄▀▄");
            ens.ajouteChaine((int)posx,(int)posy-4," ▀ ▀  ▀ ▀");
        }
        else
        {
            ens.ajouteChaine((int)posx,(int)posy,  "   ▄██▄");
            ens.ajouteChaine((int)posx,(int)posy-1," ▄██████▄");
            ens.ajouteChaine((int)posx,(int)posy-2,"██▄█▄█████");
            ens.ajouteChaine((int)posx,(int)posy-3,"  ▄▀▄▄▀▄");
            ens.ajouteChaine((int)posx,(int)posy-4," ▀ ▀  ▀ ▀");
        }
        return ens;
    }

    public static EnsembleChaines afficheAlien3(EnsembleChaines ens, double posx, double posy)
    {
        if ((int)posx%3==0)
        {
            ens.ajouteChaine((int)posx,(int)posy,  " ▄▄████▄▄");
            ens.ajouteChaine((int)posx,(int)posy-1,"██████████");
            ens.ajouteChaine((int)posx,(int)posy-2,"██▄▄██▄▄██");
            ens.ajouteChaine((int)posx,(int)posy-3," ▄▀▄▀▀▄▀▄");
            ens.ajouteChaine((int)posx,(int)posy-4,"▀        ▀");
        }
        else if ((int)posx%2==0)
        {
         ens.ajouteChaine((int)posx,(int)posy,  " ▄▄████▄▄");
         ens.ajouteChaine((int)posx,(int)posy-1,"██████████");
         ens.ajouteChaine((int)posx,(int)posy-2,"███▄▄█▄▄██");
         ens.ajouteChaine((int)posx,(int)posy-3," ▄▀▄▀▀▄▀▄");
         ens.ajouteChaine((int)posx,(int)posy-4,"  ▀    ▀");
        }
        else
        {
         ens.ajouteChaine((int)posx,(int)posy,  " ▄▄████▄▄");
         ens.ajouteChaine((int)posx,(int)posy-1,"██████████");
         ens.ajouteChaine((int)posx,(int)posy-2,"█▄▄██▄▄███");
         ens.ajouteChaine((int)posx,(int)posy-3," ▄▀▄▀▀▄▀▄");
         ens.ajouteChaine((int)posx,(int)posy-4,"    ▀▀");
        }
        return ens;
    }

    public static EnsembleChaines afficheBoss(EnsembleChaines ens, double posx, double posy ,Vie vie)
    {
        String barredevie = "";
        for (int i = 0;i<vie.getVie();i++)
        {
            barredevie += "██";
        }
        // enlever le -5 
        ens.ajouteChaine((int)posx-10,(int)posy+2,  barredevie);
        ens.ajouteChaine((int)posx,(int)posy,  "    ,-~'-----'~-.");
        ens.ajouteChaine((int)posx,(int)posy-1,"  ,^ ___         ^.");
        ens.ajouteChaine((int)posx,(int)posy-2," / .^   ^.         '\'");
        ens.ajouteChaine((int)posx,(int)posy-3,"Y  l  o  !          Y");
        ens.ajouteChaine((int)posx,(int)posy-4,"l_ `.___.'        _,[");
        ens.ajouteChaine((int)posx,(int)posy-5,"|^~'-----------''~ ^|");
        ens.ajouteChaine((int)posx,(int)posy-6,"!                   !");
        ens.ajouteChaine((int)posx,(int)posy-7," '\'                /");
        ens.ajouteChaine((int)posx,(int)posy-8,"   ^.             .^");
        ens.ajouteChaine((int)posx,(int)posy-9,"    '-.._____.,-'");
        return ens;
    }

}
 


