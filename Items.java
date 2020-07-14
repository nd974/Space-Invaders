public class Items extends Attributs
{
    private int random;

    public Items(double positionx, double positiony)
    {
        this.posx = positionx;
        this.posy = positiony;
        this.affichage = new EnsembleChaines();
        this.random = (int)(Math.random() * 11);
    }

    public int getRandom()
    {
        return this.random;
    }

    public int largeur()
    {
        return this.affichage.largeurEnsemble();
    }
}