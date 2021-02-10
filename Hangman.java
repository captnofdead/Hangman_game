import java.util.*;

public class Hangman
{
    public static void main(String args[])
    {
        System.out.println("Select the level ('e' for EASY, 'm' for MEDIUM, 'h' for HARD");
        Scanner gg = new Scanner(System.in);
        String level = gg.nextLine();
        int a[] = new int[27];
        while(!Default.checker(level,a)||(level.toLowerCase().toCharArray()[0]!='e'&&level.toLowerCase().toCharArray()[0]!='m'&&level.toLowerCase().toCharArray()[0]!='h'))
        {
            System.out.println("Invalid Level Input");
            level=gg.nextLine();
        }

        if(level.toLowerCase().toCharArray()[0]=='e')
        {
            Easy game = new Easy(level);
        }
        else if(level.toLowerCase().toCharArray()[0]=='h')
        {
            Hard game = new Hard(level); 
        }
        else if(level.toLowerCase().toCharArray()[0]=='m')
        {
            Default game = new Default(level);
        }
                    
    }
}