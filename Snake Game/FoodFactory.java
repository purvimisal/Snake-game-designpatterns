import java.util.Random;

import greenfoot.*;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Food objects.
 */
public class FoodFactory extends Creators {

    /** The random number. */
    Integer randomNumber = 0;
    
    /** The random generator. */
    Random randomGenerator;
    

    /** The city. */
    ICities city;

    /**
     * Instantiates a new food factory.
     *
     * @param city the city
     */
    FoodFactory(ICities city){
        randomGenerator = new Random();
        this.city = city;
    }
    
    /**
     * Gets the item.
     *
     * @return the item
     */
    public Actor getItem() {

        randomNumber = randomGenerator.nextInt(10);
        
        int num = randomNumber % city.getFood().size();
        final String pizza = Pizza.class.getName();
        final String burger = Burger.class.getName();
        final String fries = Fries.class.getName();
        
        
        switch(city.getFood().get(num).toString()){
                case "pizza": return new Pizza();
                
                
                case "burger" : return new Burger();
                
                case "fries":return new Fries();
                
             
          
          
          }
        return null;
        
        
    }
}
