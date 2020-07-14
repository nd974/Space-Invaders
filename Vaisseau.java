public class Vaisseau extends Attributs
{
    private Vie vie;
    
    public Vaisseau(double posx)
    {
        this.posx = posx;
        this.affichage = new EnsembleChaines();
        this.vie = new Vie(Donnee.vieVaisseau);
    }

    public Vie getVie()
    {
        return this.vie;
    }

    public int getNbvie()
    {
        return this.vie.getVie();
    }

    public double getPositionCannon()
    {
        return this.posx+this.affichage.largeurEnsemble()/2;
    }

    public void deplace(double x)
    {
        this.posx += x;
    }
} 