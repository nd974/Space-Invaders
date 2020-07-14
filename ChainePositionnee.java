public class ChainePositionnee{
    int x,y;
    String c;
    public ChainePositionnee(int a,int b, String d){x=a; y=b; c=d;}

    public boolean contient(int posx, int posy)
    {
        for(double i=x; i<=x+c.length();i++){
            if(posx >= x && posx <= x+c.length()-1 && posy == y && c.charAt(posx) != ' '){
                return true;
            }
        }
        return false;
    }
}