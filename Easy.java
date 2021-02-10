public class Easy extends Default
{
    public Easy(String s)
    {
        super(s);
    }
    int progress(String s,char [] l,String g, int frequencyarray[])
    {
        int correctguess=0;
        for(int i=0;i<l.length;i++)
        {
            if(s.toCharArray()[i]=='a'||s.toCharArray()[i]=='e'||s.toCharArray()[i]=='i'||s.toCharArray()[i]=='o'||s.toCharArray()[i]=='u'||(int)(s.toCharArray()[i])==(int)(g.toCharArray()[0]))
            {
                l[i]=s.toCharArray()[i];
            }
            if(i!=l.length-1) 
            {
                System.out.print(l[i]+ ",");
            }
            else
            {
                System.out.print(l[i]);
            }                
        }
        for(int i=0;i<l.length;i++)
        {
            if(l[i]=='_')
            {
                continue;
            }
            else
            {
                correctguess++;
            }
        }
        System.out.println("");
        return correctguess;
        //shoud we use .replace and that can make the game fast kafi.....
    }
    Boolean isnewguess(String s, int frequencyarray[])
    {
        frequencyarray[(int)'a'-(int)'_']=-1;
        frequencyarray[(int)'e'-(int)'_']=-1;
        frequencyarray[(int)'i'-(int)'_']=-1;
        frequencyarray[(int)'o'-(int)'_']=-1;
        frequencyarray[(int)'u'-(int)'_']=-1;
        if(s.toCharArray()[0]=='a'||s.toCharArray()[0]=='e'||s.toCharArray()[0]=='i'||s.toCharArray()[0]=='o'||s.toCharArray()[0]=='u')
        {
            System.out.println("It is Easy Level, Vowels already Guessed");
            return false;
        }
        else if(frequencyarray[(int)s.toCharArray()[0]-(int)'_']==-1)
        {
            System.out.println("Already Guessed, Try Another");
            return false;
        }
        return true;
    }
    protected Boolean scorestreak(int s)
    {
        if(s==2)
        {
            System.out.println("Double GUESS, 1 live awarded");
            return true;
        }
        return false;
    }
}