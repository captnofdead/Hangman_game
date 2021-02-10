

public class Hard extends Default 
{
    public Hard(String s)
    {
        super(s);
    }
    protected int lives(int c,char s)
    {
        c++;
        if(Character.toString(s).matches("[etainshrldu]"))
        {
            c++;
        }
        return c;
    }    
}
