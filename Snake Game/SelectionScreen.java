import greenfoot.*;
import java.util.*;
import javafx.util.Pair;

// TODO: Auto-generated Javadoc
/**
 * Write a description of class SelectionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionScreen extends World
{
    
    /** The cities. */
    List<ICities> cities;
    
    /** The index. */
    int index = 0;
    /**
     * Constructor for objects of class SelectionScreen.
     * 
     */
    public SelectionScreen()
    {            
        super(600, 400, 1); 
        cities = (List<ICities>) new ArrayList();
        cities.add(new Alaska("alaska.gif", "Alaska"));
        cities.add(new Utah("utah.gif","Utah"));
        cities.add(new Bangalore("bangalore.gif","Bangalore"));
        addObject(new City(cities.get(index).getImage()), 300,200);
        addObject(new Label("Alaska",50),278,25);
        addObject(new RightArrow(), 532,375);
        addObject(new LeftArrow(), 60,373);
    }
    
    /**
     * Removes the.
     */
    public void remove(){
        List objects = getObjects(null);
        removeObjects(objects);
        addObject(new RightArrow(), 532,375);
        addObject(new LeftArrow(), 60,373);
    }
    
    /**
     * Act.
     */
    public void act(){
        if(Greenfoot.isKeyDown("right")){
            if(index < 2)
            {
                remove();
                addObject(new Label(cities.get(++index).getName(),50),278,25);
                addObject(new City(cities.get(index).getImage()), 300,200);
            }
        }
        else if(Greenfoot.isKeyDown("left")){
            
            if(index > 0){
            remove();
            addObject(new Label(cities.get(--index).getName(),50),278,25);
            addObject(new City(cities.get(index).getImage()), 300,200);
        }
        }
        else if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld(cities.get(index)));
        }
        
    }
}
