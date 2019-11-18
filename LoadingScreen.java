import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadingScreen extends World
{
    private SimpleTimer timer;
    /**
     * Constructor for objects of class SelectionScreen.
     * 
     */
    public LoadingScreen()
    {    
        super(600, 400, 1);
        timer = new SimpleTimer();
        timer.mark();
        addObject(new SnakeLoadingScreen(),278,255);
        addObject(new Label("GangOFive Presents",50),278,25);
    }
    
    public void act(){
        if(timer.millisElapsed() > 5000){
        timer.mark();
        Greenfoot.setWorld(new SelectionScreen());
        }
    }
    
}
