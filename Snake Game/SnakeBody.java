import greenfoot.*; 

public class SnakeBody extends Actor
{
   private int age = 0; // track age of snake piece.
   private int lifeSpan; // restriction on how low snake gets
   
   public SnakeBody(int lifeSpan) // adds block to body 
   {
	//   GreenfootImage drawedImage = new GreenfootImage("/Users/anuragpatro/Downloads/dummy-master/images/snakeHead.jpg");
       GreenfootImage img = new GreenfootImage(20,20); //create new image with 20x20 size.
       img.setColor(Color.GRAY); //set SnakeBody colour
       img.fill(); 
       setImage(img); 
       
       this.lifeSpan = lifeSpan;
   }
   
   
    public void act() 
    {
        if(age == lifeSpan){ // when lifespan reached
            getWorld().removeObject(this); //remove snake from world
        }
        age++; // increment age after block added to body
      
    }    
    
}
