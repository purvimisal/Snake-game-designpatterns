import java.io.*;
import java.util.*;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver  
{
    // instance variables - replace the example below with your own
    private static boolean gameOver = false;

    public static boolean isGameOver()
    {
        return gameOver;
    }
    
    
    public static void endGame()
    {
        gameOver = true;
    }
    
    public static void startGame()
    {
        gameOver = false;
    }
    
    public static void writeScores(String name, int score) {
    try {
        File file = new File("scores.txt");
        FileWriter fr;
        BufferedWriter br;
        fr = new FileWriter(file, true);
        br = new BufferedWriter(fr);
        br.write(""+name+" "+score);
        br.newLine();

        br.close();
        fr.close();
    }
    catch(Exception e) { }
}    
    
    
}
