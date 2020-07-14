public class Score extends Attributs
{
    private int score;
    private boolean etat;

    public Score(int score)
    {
        this.score = score;
        this.etat = true;
        this.affichage = new EnsembleChaines();
    }

    public void ajoute(int valeur)
    {
        if (this.etat)
        {
            this.score += valeur;
        }
    }

    public void stop()
    {
        this.etat = false;
    }

    public int getScore()
    {
        return this.score;
    }
}






