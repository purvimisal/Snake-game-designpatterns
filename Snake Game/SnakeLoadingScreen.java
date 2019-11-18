import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeSelectionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeLoadingScreen extends Actor
{
    GifImage snake = new GifImage("snake1.gif");
    /**
     * Act - do whatever the SnakeSelectionScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(snake.getCurrentImage());
        
    }    
}
