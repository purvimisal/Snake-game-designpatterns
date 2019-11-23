import greenfoot.*; 

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Powerup objects.
 */
public class PowerupFactory extends Creators 
{
    
    /** The random number. */
    Integer randomNumber = 0;
    
    /**
     * Gets the item.
     *
     * @return the item
     */
    public Actor getItem(){
    	randomNumber++;
    	if(randomNumber%2 == 0) {
    	    return new Spider();
    	} else { 
    	    return new Mushroom();
    	}
    }
}
