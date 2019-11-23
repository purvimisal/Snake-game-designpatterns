import java.io.*;
import java.util.*;
// TODO: Auto-generated Javadoc
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver  
{
    
    /** The game over. */
    // instance variables - replace the example below with your own
    private static boolean gameOver = false;

    /**
     * Checks if is game over.
     *
     * @return true, if is game over
     */
    public static boolean isGameOver()
    {
        return gameOver;
    }
    
    
    /**
     * End game.
     */
    public static void endGame()
    {
        gameOver = true;
    }
    
    /**
     * Start game.
     */
    public static void startGame()
    {
        gameOver = false;
    }
    
    /**
     * Write scores.
     *
     * @param name the name
     * @param score the score
     */
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
