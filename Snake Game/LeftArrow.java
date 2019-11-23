import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// TODO: Auto-generated Javadoc
/**
 * Write a description of class RightArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftArrow extends Actor
{
    
    /** The img. */
    GreenfootImage img ;
    
    /** The timer. */
    private SimpleTimer timer;
    
    /**
     * Instantiates a new left arrow.
     */
    public LeftArrow(){
        timer = new SimpleTimer();
        timer.mark();
        img = new GreenfootImage("LeftArrow.png");
        img.scale(50,50);
        setImage(img);
        
    }
    /**
     * Act - do whatever the RightArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer.millisElapsed() > 1000){
        img.scale(img.getWidth() == 50 ? 75 : 50,img.getHeight() == 50 ? 75 : 50);
        setImage(img);
        timer.mark();
        }
    }    
}
