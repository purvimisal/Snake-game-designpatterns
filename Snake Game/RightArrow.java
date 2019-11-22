import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightArrow extends Actor
{
    GreenfootImage img ;
    private SimpleTimer timer;
    public RightArrow(){
        timer = new SimpleTimer();
        timer.mark();
        img = new GreenfootImage("RightArrow.png");
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
