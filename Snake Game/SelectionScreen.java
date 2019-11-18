import greenfoot.*;
import java.util.*;
import javafx.util.Pair;

/**
 * Write a description of class SelectionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionScreen extends World
{
    List<Pair<String, String>> cities;
    int index = 0;
    /**
     * Constructor for objects of class SelectionScreen.
     * 
     */
    public SelectionScreen()
    {            
        super(600, 400, 1); 
        cities = new ArrayList();
        cities.add(new Pair<>("alaska.gif", "Alaska"));
        cities.add(new Pair<>("utah.gif","Utah"));
        cities.add(new Pair<>("bangalore.gif","Bangalore"));
        addObject(new City(cities.get(index).getKey()), 250,250);
        addObject(new Label("Alaska",50),278,25);
    }
    public void remove(){
        List objects = getObjects(null);
        removeObjects(objects);
    }
    public void act(){
        if(Greenfoot.isKeyDown("right")){
            if(index < 2)
            {
                remove();
                addObject(new Label(cities.get(++index).getValue(),50),278,25);
                addObject(new City(cities.get(index).getKey()), 250,250);
            }
        }
        else if(Greenfoot.isKeyDown("left")){
            
            if(index > 0){
            remove();
            addObject(new Label(cities.get(--index).getValue(),50),278,25);
            addObject(new City(cities.get(index).getKey()), 250,250);
        }
        }
        else if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld(cities.get(index).getValue()));
        }
        
    }
}
