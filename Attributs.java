public class Attributs
{
    protected double posx;
    protected double posy;
    protected EnsembleChaines affichage;

    public double getposx()
    {
        return this.posx;
    }

    public double getposy()
    {
        return this.posy;
    }

    public EnsembleChaines getAffichage()
    {
        return this.affichage;
    }

    public boolean contient(double x, double y)
    {
        return this.affichage.contient((int)x, (int)y);
    }

    public static EnsembleChaines getEnsembleChaines(Object objet)
    {   
        EnsembleChaines ens = new EnsembleChaines();
        if (objet instanceof Alien)
        {
            ((Alien)objet).getAffichage().vider();
            switch(((Alien)objet).getId()) 
            {
                case Donnee.Alien1: ((Alien)objet).getAffichage().union(Affichages.afficheAlien1(new EnsembleChaines(), ((Alien)objet).getposx(), ((Alien)objet).getposy()));break;
                case Donnee.Alien2: ((Alien)objet).getAffichage().union(Affichages.afficheAlien2(new EnsembleChaines(), ((Alien)objet).getposx(), ((Alien)objet).getposy()));break;
                case Donnee.Alien3: ((Alien)objet).getAffichage().union(Affichages.afficheAlien3(new EnsembleChaines(), ((Alien)objet).getposx(), ((Alien)objet).getposy()));break;
                case Donnee.Boss: ((Alien)objet).getAffichage().union(Affichages.afficheBoss(new EnsembleChaines(), ((Alien)objet).getposx(), ((Alien)objet).getposy(),((Alien)objet).getVie()));break;
            }
            ens.union(((Alien)objet).getAffichage());
        }

        else if (objet instanceof Vaisseau)
        {
            ((Vaisseau)objet).getAffichage().vider();
            ((Vaisseau)objet).getAffichage().union(Affichages.afficheViesVaisseau(new EnsembleChaines(), ((Vaisseau)objet).getNbvie()));
            ((Vaisseau)objet).getAffichage().union(Affichages.afficheStockVaisseau(new EnsembleChaines()));
            ((Vaisseau)objet).getAffichage().union(Affichages.afficheVaisseau(new EnsembleChaines(), ((Vaisseau)objet).getposx()));
            ens.union(((Vaisseau)objet).getAffichage());
        }

        else if(objet instanceof Items)
        {
            ((Items)objet).getAffichage().vider();
            ((Items)objet).getAffichage().union(Affichages.afficheItemstockVaisseau(new EnsembleChaines(),((Items)objet).getposx(), ((Items)objet).getposy(), ((Items)objet).getRandom()));
            ens.union(((Items)objet).getAffichage());
        }

        else if (objet instanceof Projectiles)
        {
            ((Projectiles)objet).getAffichage().vider();
            ((Projectiles)objet).getAffichage().union(Affichages.afficheProjectile(new EnsembleChaines(), ((Projectiles)objet).getposx(), ((Projectiles)objet).getposy(), ((Projectiles)objet).getId()));
            ens.union(((Projectiles)objet).getAffichage());
        }

        else if (objet instanceof Score)
        {
            ((Score)objet).getAffichage().vider();
            ((Score)objet).getAffichage().union(Affichages.afficheScore(new EnsembleChaines(), ((Score)objet).getScore()));
            ens.union(((Score)objet).getAffichage());
        }
        return ens;
    }
}
