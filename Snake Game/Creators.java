import greenfoot.*; 
public abstract class Creators {

    public abstract Actor getItem();
    
    public Actor sendItem() {
        return getItem();
    }
}
