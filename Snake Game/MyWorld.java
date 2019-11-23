
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World implements IFoodListner, ILevelObserver {
    
    /** The snake. */
    SnakeHead snake;
    
    /** The food factory. */
    Creators foodFactory;

    /** The obstacle factory. */
    Creators obstacleFactory = new ObstacleFactory();
    
    /** The powerup factory. */
    Creators powerupFactory = new PowerupFactory();
    
    /** The controller. */
    LevelController controller;
    
    /** The minimum random number. */
    Integer minimumRandomNumber = 6;
    
    /** The horizontal random number. */
    Integer horizontalRandomNumber = 2;
    
    /** The timer. */
    int timer;
    
    /** The obstacle spawn time. */
    int obstacleSpawnTime = 13;
    
    /** The obstacle spawned. */
    Boolean obstacleSpawned = false;
    
    /** The power up spawned. */
    Boolean powerUpSpawned = false;
    
    /** The power up spawn time. */
    int powerUpSpawnTime = 1;
    
    /** The power up timer. */
    int powerUpTimer;
    
    /** The score card. */
    ScoreCard scoreCard;
    
    /** The city. */
    ICities city;

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    public LevelController getController() {
        return controller;
    }

    /**
     * Instantiates a new my world.
     *
     * @param city the city
     */
    public MyWorld(ICities city) {
        super(30, 30, 20, false);
        this.city = city;
        foodFactory = new FoodFactory(city);
        setBackgroundImage(city.getName());
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

    /**
     * Adds the score card.
     */
    public void addScoreCard() {
        addObject(scoreCard, 0, 1);
    }

    /**
     * Gets the timer.
     *
     * @return the timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * Adds the snake head.
     */
    public void addSnakeHead() {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        snake = new SnakeHead();
        addObject(snake, x, y);
        snake.attach(this);
        GameOver.startGame();

    }

    /**
     * Sets the background grid.
     */
    public void setBackgroundGrid() {
        GreenfootImage img = new GreenfootImage(20, 20);
        img.setColor(Color.CYAN);
        img.drawRect(0, 0, 20, 20);
        setBackground(img);
    }

    /**
     * Sets the background image.
     *
     * @param city the new background image
     */
    public void setBackgroundImage(String city) {
        if (city == "Alaska") {
            setBackground(new GreenfootImage("recycpap.jpg"));
        } else if (city == "Utah") {
            setBackground(new GreenfootImage("corkboard.jpg"));
        } else if (city == "Bangalore") {
            setBackground(new GreenfootImage("bangalore.jpg"));
        }
    }

    /**
     * Adds the food to world.
     */
    public void addFoodToWorld() {
        int x = horizontalRandomNumber + Greenfoot.getRandomNumber(24);
        int y = minimumRandomNumber + Greenfoot.getRandomNumber(20);
        scoreCard.incrementScore(controller.getState());
        while (getObjectsAt(x, y, Obstacle.class).size() > 0 && getObjectsAt(x, y, Powerup.class).size() > 0) {
            x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
            y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        }
        addObject(foodFactory.sendItem(), x, y);

    }

    /**
     * Adds the obstacle to world.
     */
    public void addObstacleToWorld() {
        int x = horizontalRandomNumber + Greenfoot.getRandomNumber(26);
        int y = minimumRandomNumber + Greenfoot.getRandomNumber(20);

        while (getObjectsAt(x, y, Food.class).size() > 0 && getObjectsAt(x, y, Powerup.class).size() > 0
                && Math.abs(getObjects(SnakeHead.class).get(0).getX() - x) < 30) {
            x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
            y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        }
        addObject(obstacleFactory.sendItem(), x, y);
    }

    /**
     * Adds the powerup to world.
     */
    public void addPowerupToWorld() {
        int x = horizontalRandomNumber + Greenfoot.getRandomNumber(26);
        int y = minimumRandomNumber + Greenfoot.getRandomNumber(20);
        while (getObjectsAt(x, y, Obstacle.class).size() > 0 && getObjectsAt(x, y, Food.class).size() > 0) {
            x = horizontalRandomNumber + Greenfoot.getRandomNumber(28);
            y = minimumRandomNumber + Greenfoot.getRandomNumber(24);
        }
        addObject(powerupFactory.sendItem(), x, y);
    }

    /**
     * Removes the obstacle.
     */
    public void removeObstacle() {
        List<Obstacle> obs = getObjects(Obstacle.class);
        removeObjects(obs);
    }

    /**
     * Removes the powerup.
     */
    public void removePowerup() {
        List<Powerup> obs = getObjects(Powerup.class);
        removeObjects(obs);
    }

    /**
     * Act.
     */
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

    /**
     * Update.
     *
     * @param obstacleInterval the obstacle interval
     * @param powerUpInterval the power up interval
     * @param speed the speed
     */
    public void update(int obstacleInterval, int powerUpInterval, int speed) {
        timer = 0;
        powerUpTimer = 0;
        obstacleSpawnTime = obstacleInterval;
        powerUpSpawnTime = powerUpInterval;
        this.snake.setSpeed(speed);
    }
}
