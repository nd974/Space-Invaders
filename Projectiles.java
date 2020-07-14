public class Projectiles extends Attributs
{
    private int identifiant;

    public Projectiles(double posx, double posy, int id){
        this.posx = posx;
        this.posy = posy;
        this.identifiant = id;
        this.affichage = new EnsembleChaines();
    }

    public int getId()
    {
        return this.identifiant;
    }

    public void attaque()
    {
        if (this.identifiant==Donnee.Boss)
        {
            this.posy-=1;
        }

        else
        {
            if (Donnee.VaisseauAmeliore)
            {
                this.posy+=1.5;
            }
            else
            {
                this.posy+=1;
            }
        } 
    }
}