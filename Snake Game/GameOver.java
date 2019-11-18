
public class GameOver  
{
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
