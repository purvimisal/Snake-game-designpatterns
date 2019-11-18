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
}
