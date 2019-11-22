
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World implements IFoodListner, ILevelObserver {
    SnakeHead snake;
    Creators foodFactory = new FoodFactory();
    Creators obstacleFactory = new ObstacleFactory();
    Creators powerupFactory = new PowerupFactory();
    LevelController controller;
    Integer minimumRandomNumber = 3;
    Integer horizontalRandomNumber = 2;
    int timer;
    int obstacleSpawnTime = 13;
    Boolean obstacleSpawned = false;
    Boolean powerUpSpawned = false;
    int powerUpSpawnTime = 1;
    int powerUpTimer;
    ScoreCard scoreCard;

    public LevelController getController() {
        return controller;
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    // public MyWorld() {
    // super(30, 30, 20, false);
    // setBackgroundGrid();
    // addSnakeHead();
    // int x = Greenfoot.getRandomNumber(getWidth());
    // int y = Greenfoot.getRandomNumber(getHeight());
    // addObject(foodFactory.sendItem(), x, y);

    // controller = new LevelController();
    // scoreCard = new ScoreCard();
    // controller.attach(this);
    // scoreCard.registerObserver(controller);
    // controller.changeToLevel0();
    // timer = 0;
    // addScoreCard();
    // }
    public MyWorld(String file) {
        super(30, 30, 20, false);
        setBackgroundImage(file);
        addSnakeHead();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(foodFactory.sendItem(), x, y);
        controller = new LevelController();
        scoreCard = new ScoreCard();
        controller.attach(this);
        controller.changeToLevel1();
        scoreCard.registerObserver(controller);
        timer = 0;
        powerUpTimer = 0;
        addScoreCard();
    }

    public void addScoreCard() {
        addObject(scoreCard, 4, 1);
    }

    public int getTimer() {
        return timer;
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

    public void setBackgroundImage(String city) {
        if (city == "Alaska") {
            setBackground(new GreenfootImage("recycpap.jpg"));
        } else if (city == "Utah") {
            setBackground(new GreenfootImage("corkboard.jpg"));
        } else if (city == "Bangalore") {
            setBackground(new GreenfootImage("bangalore.jpg"));
        }
    }

    public void addFoodToWorld() {
        int x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
        int y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        scoreCard.incrementScore(controller.getState());
        while (getObjectsAt(x, y, Obstacle.class).size() > 0 && getObjectsAt(x, y, Powerup.class).size() > 0) {
            x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
            y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        }
        addObject(foodFactory.sendItem(), x, y);

    }

    public void addObstacleToWorld() {
        int x = horizontalRandomNumber + Greenfoot.getRandomNumber(26);
        int y = minimumRandomNumber + Greenfoot.getRandomNumber(24);

        while (getObjectsAt(x, y, Food.class).size() > 0 && getObjectsAt(x, y, Powerup.class).size() > 0
                && Math.abs(getObjects(SnakeHead.class).get(0).getX() - x) < 30) {
            x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
            y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        }
        addObject(obstacleFactory.sendItem(), x, y);
    }

    public void addPowerupToWorld() {
        int x = horizontalRandomNumber + Greenfoot.getRandomNumber(26);
        int y = minimumRandomNumber + Greenfoot.getRandomNumber(25);
        while (getObjectsAt(x, y, Obstacle.class).size() > 0 && getObjectsAt(x, y, Food.class).size() > 0) {
            x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
            y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        }
        addObject(powerupFactory.sendItem(), x, y);
    }

    public void removeObstacle() {
        List<Obstacle> obs = getObjects(Obstacle.class);
        removeObjects(obs);
    }

    public void removePowerup() {
        List<Powerup> obs = getObjects(Powerup.class);
        removeObjects(obs);
    }

    public void act() {
        timer++;
        if (powerUpSpawned)
            powerUpTimer++;

        if (timer % (70 * obstacleSpawnTime) == 0) {
            if (obstacleSpawned) {
                obstacleSpawned = false;
                removeObstacle();
            } else {
                addObstacleToWorld();
                obstacleSpawned = true;
            }
        }
        if (timer % (70 * powerUpSpawnTime) == 0) {
            addPowerupToWorld();
            powerUpSpawned = true;
            powerUpTimer = 0;
        }

        if (powerUpTimer == 210) {
            removePowerup();
            powerUpSpawned = false;
            powerUpTimer = 0;
        }

    }

    public void update(int obstacleInterval, int powerUpInterval, int speed) {
        timer = 0;
        powerUpTimer = 0;
        obstacleSpawnTime = obstacleInterval;
        powerUpSpawnTime = powerUpInterval;
        this.snake.setSpeed(speed);
    }
}
