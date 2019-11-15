import greenfoot.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class SnakeHead extends Actor implements IFoodPublisher, IScoreRegister {
    private final int RIGHT = 0;
    private final int DOWN = 90;
    private final int LEFT = 180;
    private final int UP = 270;

    private int SPEED = 5;
    private int counter = 0;
    private int speedDivision = 0;
    private int applesConsumed =0;

    private IScoreObserver observer;
    private ArrayList<IFoodListner> listner;

    public SnakeHead() {
        listner = new ArrayList<>();
        renderSnakeHead();
    }

    public void renderSnakeHead() {
        GreenfootImage img = new GreenfootImage(20, 20);
        img.setColor(Color.LIGHT_GRAY);
        img.fill();
        setImage(img);
        setRotation(Greenfoot.getRandomNumber(4) * 90);
    }

    /**
     * Attach a Key Pad Observer
     * 
     * @param obj Observer
     */
    public void attach(IFoodListner obj) {
        listner.add(obj);
    }

    /**
     * Remove Key Pad Observer
     * 
     * @param obj Observer
     */
    public void removeObserver(IFoodListner obj) {
        int i = listner.indexOf(obj);
        if (i >= 0)
            listner.remove(i);
    }

    /**
     * Notify all Observers of Update Event
     */
    public void notifyListner() {
        for (int i = 0; i < listner.size(); i++) {
            IFoodListner listner = this.listner.get(i);
            listner.addFoodToWorld();

        }
    }

    public void act() {
        crawl();

        // If the SnakeHead is touch the Apple then the following will be true and run
        // the code which hides the Apple.
        if(!GameOver.isGameOver()) {
        if (isTouching(Food.class)) {
            removeTouching(Food.class);

            applesConsumed++;
            if(applesConsumed%5 == 0) {
                notifyController();
            }
            notifyListner();
            speedDivision++;
            // Greenfoot.playSound("bite.mp3");
        }

        if (isTouching(SnakeBody.class)) {
            gameover();
            // Greenfoot.playSound("gameOver.mp3");
        }

        if (speedDivision == 5) {
            speedDivision = 0;
            SPEED = SPEED - 1;
            // Greenfoot.playSound("speedup.mp3");
        }

        if (getX() < 0) {
            setLocation(getWorld().getWidth(), getY());
            // Greenfoot.playSound("jump.mp3");
        }

        if (getX() > getWorld().getWidth()) {
            setLocation(0, getY());
            // Greenfoot.playSound("jump.mp3");
        }

        if (getY() < 0) {
            setLocation(getX(), getWorld().getHeight());
            // Greenfoot.playSound("jump.mp3");
        }

        if (getY() > getWorld().getHeight()) {
            setLocation(getX(), 0);
            // Greenfoot.playSound("jump.mp3");
        }
    }

}
    
