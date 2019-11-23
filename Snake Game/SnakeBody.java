import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This part of the code makes up and adds to the body of the snake.
 * 
 */
public class SnakeBody extends Actor
{
   private int age = 0;
   private int lifeSpan;
   
   public SnakeBody(int lifeSpan) 
   {
   
	   GreenfootImage img = new GreenfootImage(14,14); 
       img.setColor(new Color(72,120,238));  
       img.fill(); 
       setImage(img); 
       this.lifeSpan = lifeSpan; 
   }
   
   
    public void act() 
    {
        if(age == lifeSpan){
            getWorld().removeObject(this); 
        }
        age++;
    }
    public void reduceLength() {
        age = (age*2)/3;
    }
}
