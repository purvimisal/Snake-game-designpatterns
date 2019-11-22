import greenfoot.*; 

public class PowerupFactory extends Creators 
{
    Integer randomNumber = 0;
    public Actor getItem(){
    	randomNumber++;
    	if(randomNumber%2 == 0) {
    	    return new Spider();
    	} else { 
    	    return new Mushroom();
    	}
    }
}
