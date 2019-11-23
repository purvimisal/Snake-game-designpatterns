import greenfoot.*; 

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Obstacle objects.
 */
public class ObstacleFactory extends Creators 
{
    
    /** The random number. */
    Integer randomNumber=0;
    
    /**
     * Gets the item.
     *
     * @return the item
     */
    public Actor getItem(){
    	randomNumber++;
    	if(randomNumber%2 == 0) {
    	    return new Rectangle();
    	} else { 
    	    return new Danger();
    	}
    }
}
