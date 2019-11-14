import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World implements IFoodListner {
    SnakeHead snake;
    Creators foodFactory = new FoodFactory();

    LevelController controller;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        super(30, 30, 20, false);
        setBackgroundGrid();
        addSnakeHead();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(foodFactory.sendFood(), x, y);
        controller = new LevelController();
        snake.registerObserver(controller);

    }

    public void addSnakeHead() {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        snake = new SnakeHead();
        addObject(snake, x, y);
        snake.attach(this);
        GameOver.startGame();

    }

    public void setBackgroundGrid() {
        GreenfootImage img = new GreenfootImage(20, 20);
        img.setColor(Color.CYAN);
        img.drawRect(0, 0, 20, 20);
        setBackground(img);
    }

    public void addFoodToWorld() {
        int x = Greenfoot.getRandomNumber(28);
        int y = Greenfoot.getRandomNumber(28);

        addObject(foodFactory.sendFood(), x, y);

    }

    public void act() {

    }
    

}
