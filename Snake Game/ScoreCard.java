import greenfoot.*;

public class ScoreCard extends Actor {
    
    private int currentScore;
    
    public void updateScoreCard() {
    
        setImage(new GreenfootImage("Score: " + currentScore, 30, Color.BLACK, new Color(0,0,0,0)));
    }

    public ScoreCard() {
        updateScoreCard();
    }
    
    public void act() {
        
    }
}