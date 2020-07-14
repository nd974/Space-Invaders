public class Vie
{
    private int vie;

    public Vie(int v)
    {
        this.vie = v;
    }

    public int getVie()
    {
        return this.vie;
    }

    public void ajoute()
    {
        this.vie ++;
    }

    public void retire(int degat)
    {
        this.vie -= degat;
    }
}






