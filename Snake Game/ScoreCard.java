import greenfoot.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreCard.
 */
public class ScoreCard extends Actor implements IScoreRegister {

    /** The current score. */
    private int currentScore = 0;
    
    /** The observer. */
    private IScoreObserver observer;
    
    /** The level. */
    private String level = "Level : 0 ";

    /**
     * Update score card.
     */
    public void updateScoreCard() {
        String text = "Score: " + currentScore + "              " + level;
        GreenfootImage textImage = new GreenfootImage(text, 24, new Color(0, 255, 128), new Color(0, 0, 0, 0));
        GreenfootImage image = new GreenfootImage(1200, 60);
        image.setColor(new Color(196, 196, 0));
        image.fill();
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, 1200, 60);
        image.drawImage(textImage, 750, 16);
        setImage(image);
    }

    /**
     * Instantiates a new score card.
     */
    public ScoreCard() {
        updateScoreCard();
    }

    /**
     * Act.
     */
    public void act() {

    }

    /**
     * Increment score.
     *
     * @param level the level
     */
    public void incrementScore(String level) {
        currentScore++;
        StringBuilder temp = new StringBuilder(level);
        temp.insert(temp.length()-1, " : ");
        temp.append(" ");
        this.level = temp.toString();
        updateScoreCard();
        if (currentScore % 7 == 0) {
            notifyController();
        }
    }

    /**
     * Register observer.
     *
     * @param observer the observer
     */
    @Override
    public void registerObserver(IScoreObserver observer) {
        this.observer = observer;

    }

    /**
     * Notify controller.
     */
    @Override
    public void notifyController() {

        observer.changeState(currentScore);
    }
}
