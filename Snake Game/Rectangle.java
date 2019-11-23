import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// TODO: Auto-generated Javadoc
/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Obstacle
{
    
    /**
     * Instantiates a new rectangle.
     */
    public Rectangle() {
         int height = Greenfoot.getRandomNumber(120);
         int width = Greenfoot.getRandomNumber(120);
         if(height < 50) height = 50;
         if(width  < 50) width = 50;
         GreenfootImage image = new GreenfootImage(width, height);
         image.setColor(Color.RED);
         image.fill();
         setImage(image);
    }
   
    /**
     * Act.
     */
    public void act() 
    {
        int num = Greenfoot.getRandomNumber(50);
        if(num%2==0){
        turn(5);
    }
        
    }    
}
