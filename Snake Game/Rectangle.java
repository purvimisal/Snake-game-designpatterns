import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Obstacle
{
    public Rectangle() {
         int height = Greenfoot.getRandomNumber(150);
         int width = Greenfoot.getRandomNumber(150);
         if(height < 20) height = 20;
         if(width  < 20) width = 20;
         GreenfootImage image = new GreenfootImage(width, height);
         image.setColor(Color.RED);
         image.fill();
         setImage(image);
    }
   
    public void act() 
    {
        // Add your action code here.
    }    
}
