import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This part of the code makes up and adds to the body of the snake.
 * 
 */
public class SnakeBody extends Actor
{
   private int age = 0; //Allows program to track age of snake piece.
   private int lifeSpan; //Puts a limit on how big the snake can get.
   
   public SnakeBody(int lifeSpan) // This function simply generates another black block to be used as a SnakeBody.
   {
    //   GreenfootImage drawedImage = new GreenfootImage("/Users/anuragpatro/Downloads/dummy-master/images/snakeHead.jpg");
	   GreenfootImage img = new GreenfootImage(14,14); //Create a new image with 20x20 as the size.
       img.setColor(new Color(72,120,238));  //set SnakeBody colour
       img.fill(); //Fill the block.
       setImage(img); //Save our changes.
       this.lifeSpan = lifeSpan; //Refers to this objects property.
   }
   
   
    public void act() 
    {
        if(age == lifeSpan){ //Check if lifespan is reached.
            getWorld().removeObject(this); //Remove this object from the world.
        }
        age++; //Add to age once SnakeBody is added on.
    }
    public void reduceLength() {
        age = (age*2)/3;
    }
}
