public class Alien extends Attributs
{
    private int identifiant;
    private Vie vie ;
    private double deplacement = Donnee.deplacementAlien;
    private double compteurDeDeplacement = 0;

    public Alien(double positionx, double positiony, int id)
    {
        this.posx = positionx;
        this.posy = positiony;
        this.identifiant = id;
        this.vie = new Vie(Donnee.vieAlien);
        this.affichage = new EnsembleChaines();
        if (id == Donnee.IDBoss)
        {
            this.vie = new Vie(Donnee.vieBoss);
            this.deplacement = Donnee.deplacementBoss;
        }
    }

    public int getId()
    {
        return this.identifiant;
    }

    public int getScore()
    {
        if (this.identifiant==Donnee.Boss)
        {
            return Donnee.pointEliminationBoss;
        }
        return Donnee.pointEliminationAlien;
    }

    public int getNbvie()
    {
        return this.vie.getVie();
    }


    public Vie getVie()
    {
        return this.vie;
    }

    public double getPositionCannon()
    {
        return this.posx+this.affichage.largeurEnsemble()/2;
    }

    public void retireVie(int degat)
    {
        this.vie.retire(degat);
    }

    public void evolue()
    {
        this.posx += this.deplacement;
        this.compteurDeDeplacement ++;
        if (compteurDeDeplacement>Donnee.largeurEcran){
            compteurDeDeplacement = 0;
            this.posy-=1;
            this.deplacement*=-1;
        }
    }
}