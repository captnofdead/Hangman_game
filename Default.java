import java.util.*;
public class Default 
{
    private static final String[] lol = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public Default(String s)
    {
        System.out.println("Enter The Word to be guessed");
        Scanner gg = new Scanner(System.in);
        int frequencyarray[]= new int[28];
        String wordtoguess = gg.nextLine();
        while(!checker(wordtoguess,frequencyarray))
        {
            wordtoguess = gg.nextLine();
        }
        char [] userguesser;
        if(checker(wordtoguess,frequencyarray))
        {
            freqarray(wordtoguess, frequencyarray);
            int count=0;
            int streak=0;
            int counta=0;
            int correctguess=0;
            userguesser = new char[wordtoguess.toCharArray().length]; 
            for(int i=0;i<userguesser.length;i++)
            {
                userguesser[i]='_';
                count++;
            }
            System.out.println("Starting the Game.....");
            while(counta<7&&count>correctguess)
            {
                System.out.println("Enter your guess");
                String f = gg.nextLine();
                while(!checker(f,frequencyarray)||!isnewguess(f,frequencyarray))
                {
                    f=gg.nextLine();
                }
                if(frequencyarray[(int)f.toCharArray()[0]-(int)('_')]>0)
                {
                    System.out.println("This is a correct guess");
                    System.out.println("     Progress-    ");
                    correctguess=progress(wordtoguess,userguesser,f,frequencyarray);                    
                    streak++;
                    frequencyarray[(int)f.toCharArray()[0]-(int)('_')]=-1;
                    if(scorestreak(streak))
                    {
                        counta--;
                        streak=0;
                    }
                }
                else
                {
                    System.out.println("This is a Wrong guess");                    
                    System.out.println("     Progress-    ");
                    correctguess=progress(wordtoguess,userguesser,f,frequencyarray);
                    char c = f.toCharArray()[0];
                    counta = lives(counta,c);
                    System.out.println("Number of Guess Remaining are " + (7-counta));
                    streak=0;
                    frequencyarray[(int)f.toCharArray()[0]-(int)('_')]=-1;
                }
                if (counta == 1) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("___|___");
                    System.out.println();
                }
                if (counta == 2) {
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (counta == 3) {
                    System.out.println("   ____________");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   | ");
                    System.out.println("___|___");
                }
                if (counta == 4) {
                    System.out.println("   ____________");
                    System.out.println("   |          _|_");
                    System.out.println("   |         /   \\");
                    System.out.println("   |        |     |");
                    System.out.println("   |         \\_ _/");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (counta == 5) {
                    System.out.println("   ____________");
                    System.out.println("   |          _|_");
                    System.out.println("   |         /   \\");
                    System.out.println("   |        |     |");
                    System.out.println("   |         \\_ _/");
                    System.out.println("   |           |");
                    System.out.println("   |           |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (counta == 6) {

                    System.out.println("   ____________");
                    System.out.println("   |          _|_");
                    System.out.println("   |         /   \\");
                    System.out.println("   |        |     |");
                    System.out.println("   |         \\_ _/");
                    System.out.println("   |           |");
                    System.out.println("   |           |");
                    System.out.println("   |          / \\ ");
                    System.out.println("___|___      /   \\");
                }
            }
            if(correctguess==count)
            {
                System.out.println("Congratulations, You won the game :) GGWP");
            }
            else
            {
                System.out.println("GAME OVER! You Lost :( NT");
                if (counta == 7) 
                {
                    System.out.println("   ____________");
                    System.out.println("   |          _|_");
                    System.out.println("   |         /   \\");
                    System.out.println("   |        |     |");
                    System.out.println("   |         \\_ _/");
                    System.out.println("   |          _|_");
                    System.out.println("   |         / | \\");
                    System.out.println("   |          / \\ ");
                    System.out.println("___|___      /   \\");
                    System.out.println("The word was " + wordtoguess);
                }
            }            
        }
    }
    int progress(String s,char [] l,String g, int frequencyarray[])
    {
        int correctguess=0;
        for(int i=0;i<l.length;i++)
        {
            if((int)(s.toCharArray()[i])==(int)(g.toCharArray()[0]))
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
    static void freqarray(String s, int frequencyarray[])
    {
        char[] g = s.toLowerCase().toCharArray();
        for( int i=0;i<g.length;i++)
        {
            frequencyarray[(int)g[i]-(int)('_')]++;
        }
        
    }
    static Boolean checker(String s,int frequencyarray[])
    {
        if(s.toCharArray()[0]=='*')
        {
            hint(frequencyarray);
            System.out.println("No More Hints Now");
        }
        char[] checkguess = s.toCharArray();
        for (int i = 0; i < checkguess.length; i++) {
            if ((int) checkguess[i] <= (int) ('z') && (int) checkguess[i] >= (int) ('a')) {
                continue;
            } else {
                System.out.println("Please Enter Only Alphabets");
                return false;
            }
        }
        return true;
    }

    Boolean isnewguess(String s, int frequencyarray[]) {
        if (frequencyarray[(int) s.toCharArray()[0] - (int) ('_')] == -1) {
            System.out.println("Already Guessed, Try Another");
            return false;
        }
        return true;
    }

    protected int lives(int c, char s) {
        c++;
        return c;
    }

    protected Boolean scorestreak(int s) {
        if (s == 3) {
            System.out.println("Triple GUESS, 1 live awarded");
            return true;
        }
        return false;
    }

    protected static void hint(int frequencyarray[]) {
        int c = 0;
        String s = "";
        while (c != 5) {
            String word = lol[new Random().nextInt(lol.length)];
            while (frequencyarray[(int) word.toCharArray()[0] - (int) ('_')] < 0)
            {
                word = lol[new Random().nextInt(lol.length)];
            }
            s=s+word+",";
            c++;
        }
        System.out.println("One of the letters of this word will be");
        System.out.println(s);    
    }   
}
