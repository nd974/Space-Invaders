import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Iterator;

public class GestionJeu
{
    private Vaisseau vaisseau;
    private Score score;
    private EnsembleChaines affichage;

    private ArrayList<Projectiles> listeProjectiles;
    private ArrayList<Projectiles> listeBombeEnnemi;
    private ArrayList<Alien> listeAliens;
    private ArrayList<Items> listeItems;
    private ArrayList<Integer> listeScores;


    public GestionJeu(){
        this.score = new Score(0);
        this.affichage = new EnsembleChaines();
        this.vaisseau = new Vaisseau((Donnee.largeurEcran/2));
        this.listeProjectiles = new ArrayList<>();
        this.listeAliens = new ArrayList<>();
        this.listeItems = new ArrayList<>();
        this.listeBombeEnnemi = new ArrayList<>();
        this.listeScores = new ArrayList<>();
        construitlisteAlienslien();
    }
    
    public void toucheGauche(){
        if(vaisseau.getposx() > 0) 
        {
            vaisseau.deplace(-Donnee.deplace);
        }
    }

    public void toucheDroite(){
        if(vaisseau.getposx() < Donnee.largeurEcran-this.vaisseau.getAffichage().largeurEnsemble())
        {
            vaisseau.deplace(Donnee.deplace);
        }
    }

    public void toucheEspace()
    {
        // System.out.println(this.vaisseau.getAffichage().hauteurEnsemble());//////////////////////////////
        // System.out.println(this.affichage.hauteurEnsemble());
        // Scores();
        if (Donnee.stock_missile>0)
        {
            this.listeProjectiles.add(new Projectiles(vaisseau.getPositionCannon(),2, Donnee.IDVaisseau));// TODO enlever 2 -> hauteru vaisseau
            Donnee.stock_missile--;
        }
        
    }

    public void toucheEnter()
    {
        if (this.vaisseau.getVie().getVie()<1)
        {
            relanceJeu();
            Donnee.stock_missile = 3;
        }
    }

    public EnsembleChaines getChaines()
    {
        return this.affichage;
    }

    public void jouerUnTour(){

        if (Donnee.tempAmelioration >= 0)
        {
            if (Donnee.tempAmelioration == 0)
            {
                Donnee.VaisseauAmeliore = false;
            }
            Donnee.tempAmelioration--;
        }
        // si la liste des alien est vide
        if (listeAliens.isEmpty())
        {
            CombatBoss();
        }
        gererProjectiles();
        
        // Reinitialistaion de l'affichage
        affichage.vider();

        // Affichages 
        score.ajoute(1);
        affichage.union(Attributs.getEnsembleChaines(score));
        affichage.union(Affichages.afficheLimitation(new EnsembleChaines()));
        affichage.union(Attributs.getEnsembleChaines(this.vaisseau));
        afficheAliens();
        afficheProjectiles();
        afficheAttaqueEnnemi();//redondant
        afficheItems();
        afficheHighScore();
        if (Donnee.VaisseauAmeliore)
        {
            affichage.union(Affichages.afficheItemsAmelioration(new EnsembleChaines()));
        }

        // si demande de nouvelle vague
        if (Donnee.nouvelle_vague)
        {
            Donnee.stock_missile=3;
            construitlisteAlienslien();
        }

        //si le vaisseau na plus de vie
        if (this.vaisseau.getNbvie()<1)
        {
            finPartie();
        }

        if (this.score.getScore()>=999999999)
        {
            // TODO afficher courone ou autre ...
            System.out.println("courone");
        }
    }                                       
    
    public void construitlisteAlienslien()
    {
        // TODO Lie a DOnnees
        int hauteur = Donnee.hauteurEcran-10;
        for(int i=0;i<Donnee.nombreALien;i++){
            for(int j=5;j<Donnee.largeurEcran-10;j+=15){// TODO largeur alien
                this.listeAliens.add(new Alien(j,hauteur,(int)(Math.random() * 3)));
            }
            hauteur -= 5;// TODO hauteur alien
        }
        Donnee.nouvelle_vague = false;
    }

    public void relanceJeu() // TODO redondant
    {
        this.score = new Score(0);
        this.affichage = new EnsembleChaines();
        this.vaisseau = new Vaisseau((Donnee.largeurEcran/2));
        this.listeProjectiles = new ArrayList<>();
        this.listeAliens = new ArrayList<>();
        this.listeItems = new ArrayList<>();
        this.listeBombeEnnemi = new ArrayList<>();
    }

    public void afficheProjectiles()
    {
        for (int i = listeProjectiles.size()-1 ;i>=0; i--) 
        {
            listeProjectiles.get(i).attaque();
            affichage.union(Attributs.getEnsembleChaines(listeProjectiles.get(i)));
            /**Si il atteint la limite*/
            if (listeProjectiles.get(i).getposy() >=Donnee.hauteurEcran-7) 
            {
                listeProjectiles.remove(listeProjectiles.get(i));
                Donnee.stock_missile++;
            }
        }
    }

    public void afficheAliens() //  faire class BOSS et faire afficheBoss
    {

        for (int i = listeAliens.size()-1 ;i>=0; i--) 
        {
            listeAliens.get(i).evolue();
            this.affichage.union(Attributs.getEnsembleChaines(listeAliens.get(i)));
            if (listeAliens.get(i).getposy() <= 7)//hauteur vaisseau 
            {
                listeAliens.remove(listeAliens.get(i));
                this.vaisseau.getVie().retire(1);
            }
            if (listeAliens.get(i).getId()==Donnee.Boss && listeAliens.get(i).getposx() %10 == 0)
            {
                this.listeBombeEnnemi.add(new Projectiles(listeAliens.get(i).getPositionCannon(), listeAliens.get(i).getposy(), Donnee.Boss));
            }
            if (listeAliens.get(i).getNbvie()<=0)
            {
                listeAliens.remove(listeAliens.get(i));
            }
        }
    }

    public void afficheAttaqueEnnemi()
    {
        for (int i = listeBombeEnnemi.size()-1 ;i>=0; i--) 
        {
            listeBombeEnnemi.get(i).attaque();
            affichage.union(Attributs.getEnsembleChaines(listeBombeEnnemi.get(i)));
            if (this.vaisseau.contient(listeBombeEnnemi.get(i).getposx(), listeBombeEnnemi.get(i).getposy()))
            {
                this.listeBombeEnnemi.remove(listeBombeEnnemi.get(i));
                this.vaisseau.getVie().retire(1);
            }
            if (listeBombeEnnemi.get(i).getposy() <=0)
            {
                listeBombeEnnemi.remove(listeBombeEnnemi.get(i));
            }
        }
    }

    public void afficheItems()
    {
        for(Items items : listeItems)
        {
            affichage.union(Attributs.getEnsembleChaines(items));
        }
    }

    public void afficheHighScore()
    {
        if (listeScores.isEmpty())
        {
            affichage.union(Affichages.afficheHighScoreNull(new EnsembleChaines()));
        }
        else
        {
            if (this.vaisseau.getVie().getVie()>=1)
            {
                affichage.union(Affichages.afficheBestHighScore(new EnsembleChaines(), this.listeScores));
            }
        }
    }


    public void finPartie()
    {
        this.affichage.vider();
        this.listeScores.add(this.score.getScore());
        this.listeAliens.clear();
        this.score.stop();
        this.affichage.union(Affichages.afficheGAMEOVER(new EnsembleChaines(), this.score));
        // Executable.demandeEnregistrement();
        // Executable.ajouteButtonRejouer(Donnee.Scene);
    }

    public void CombatBoss()
    { 
        Donnee.stock_missile = 3;
        this.listeProjectiles.clear();
        this.listeAliens.add(new Alien(Donnee.largeurEcran/10, Donnee.hauteurEcran-10, Donnee.Boss));
    }

    public void gererProjectiles()
    {
        Iterator<Projectiles> it = listeProjectiles.iterator();
        while( it.hasNext() ) 
        {
            Projectiles projectile = it.next();
            gererAlien(projectile, it);
            gererItems(projectile, it);
        }
    }

    public void gererAlien(Projectiles projectile, Iterator<Projectiles> it)
    {      
        for(Alien alien : listeAliens)
        {
            if (alien.contient(projectile.getposx(), projectile.getposy()))
            {
                it.remove();
                Donnee.stock_missile++;
                if (alien.getId()==Donnee.Boss && alien.getNbvie()<2)
                {
                    this.listeBombeEnnemi.clear();
                    this.listeProjectiles.clear();
                    Donnee.nouvelle_vague = true;               
                    listeItems.add(new Items(0-(int)(Math.random() * (5 - Donnee.largeurEcran-10 )),0-(int)(Math.random() * ( 5 - Donnee.hauteurEcran/2 ))));    
                }
                if (Donnee.VaisseauAmeliore)
                {
                    alien.retireVie(4);
                }
                else
                {
                    alien.retireVie(1);
                }
                this.score.ajoute(alien.getScore());
            }
        }
    }

    public void gererItems(Projectiles projectile, Iterator<Projectiles> it)
    {
        Iterator<Items> iterateurItem = listeItems.iterator();
        while( iterateurItem.hasNext() ) 
        {
            Items item = iterateurItem.next();
            if (item.contient(projectile.getposx(), projectile.getposy()))
            {
                it.remove();
                Donnee.stock_missile++;
                // A faire un getters dans ietms
                if (item.getRandom()==Donnee.ItemCoeur)
                {
                    if (this.vaisseau.getVie().getVie()<3)
                    {
                        this.vaisseau.getVie().ajoute();
                        iterateurItem.remove();
                    }
                }

                else if (item.getRandom()==Donnee.ItemAmelioration)
                {
                    Donnee.VaisseauAmeliore = true;
                    Donnee.tempAmelioration = 500;
                    iterateurItem.remove();
                }

                else if (item.getRandom()%2==0 && item.getRandom() != Donnee.ItemCoeur)
                {
                    score.ajoute(Donnee.ScorePieceItem);
                    iterateurItem.remove();
                }

                else
                {
                    this.vaisseau.getVie().retire(1);
                    iterateurItem.remove();
                }
                
            }
        }
    }
}