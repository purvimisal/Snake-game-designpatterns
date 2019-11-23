import greenfoot.*; 
// TODO: Auto-generated Javadoc

/**
 * The Class Creators.
 */
public abstract class Creators {

    /**
     * Gets the item.
     *
     * @return the item
     */
    public abstract Actor getItem();
    
    /**
     * Send item.
     *
     * @return the actor
     */
    public Actor sendItem() {
        return getItem();
    }
}
