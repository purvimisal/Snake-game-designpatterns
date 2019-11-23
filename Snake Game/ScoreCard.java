import greenfoot.*;

public class ScoreCard extends Actor implements IScoreRegister {

    private int currentScore = 0;
    private IScoreObserver observer;
    private String level = "Level : 0 ";

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

    public ScoreCard() {
        updateScoreCard();
    }

    public void act() {

    }

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

    @Override
    public void registerObserver(IScoreObserver observer) {
        this.observer = observer;

    }

    @Override
    public void notifyController() {

        observer.changeState(currentScore);
    }
}
