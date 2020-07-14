import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class EnsembleChaines {
    ArrayList<ChainePositionnee> chaines;
    public EnsembleChaines()
    {
        chaines= new ArrayList<ChainePositionnee>(); 
    }

    public void ajouteChaine(int x, int y, String c){
        chaines.add(new ChainePositionnee(x,y,c));}

    public void union(EnsembleChaines e){
        for(ChainePositionnee c : e.chaines)
            chaines.add(c);
    }

    public boolean contient(int posx, int posy){
        for(ChainePositionnee c: chaines){
            if (c.x<=posx  && c.y == posy && posx < c.x+c.c.length())
                return true;
        } 
        return false;
    }

    public void vider()
    {
         chaines.clear();
    }

    public int largeurEnsemble()
    {
        Collections.sort(this.chaines, new ComparateurChaines());
        if ((this.chaines.get(this.chaines.size()-1)).c.length()%2==1)
        {
            return ((this.chaines.get(this.chaines.size()-1)).c.length())-1;
        }
        return (this.chaines.get(this.chaines.size()-1)).c.length();
    }

    public int hauteurEnsemble()
    {
        return this.chaines.size();
    }
}

class ComparateurChaines implements Comparator<ChainePositionnee>
{
    public int compare(ChainePositionnee c1, ChainePositionnee c2)
    {
        return c1.c.length()-c2.c.length();
    }
}