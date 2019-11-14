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
}