import greenfoot.*; 

public class ObstacleFactory extends Creators 
{
    Integer randomNumber=0;
    public Actor getItem(){
    	randomNumber++;
    	if(randomNumber%2 == 0) {
    	    return new Rectangle();
    	} else { 
    	    return new Rectangle();
    	}
    }
}
