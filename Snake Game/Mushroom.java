import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Powerup
{
    int timer = 0;
    /**
     * Act - do whatever the Rat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Mushroom() {
         getImage().scale(30,30);
    }
    public void act() 
    {
       timer++;
        if(timer % 15 == 0) {
            if (this.getImage().toString().contains("mushroom.png"))
            {   
                setImage(new GreenfootImage(10,10));
                this.getImage().scale(30,30);
            } else {
                setImage(new GreenfootImage("mushroom.png"));
                this.getImage().scale(30,30);
            }
        }
    }    
}
