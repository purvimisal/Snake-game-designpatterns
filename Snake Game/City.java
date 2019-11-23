import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// TODO: Auto-generated Javadoc
/**
 * Write a description of class SFSelectionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City extends Actor
{
    
    /** The city. */
    GifImage city;
    
    /**
     * Instantiates a new city.
     *
     * @param file the file
     */
    public City(String file){
        
        city = new GifImage(file);
    }
    /**
     * Act - do whatever the SnakeSelectionScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(city.getCurrentImage());
        
    }    
}
