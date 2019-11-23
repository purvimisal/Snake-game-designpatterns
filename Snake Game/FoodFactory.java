import java.util.Random;

import greenfoot.*;

public class FoodFactory extends Creators {

    Integer randomNumber = 0;
    Random randomGenerator;
    

    ICities city;

    FoodFactory(ICities city){
        randomGenerator = new Random();
        this.city = city;
    }
    public Actor getItem() {

        randomNumber = randomGenerator.nextInt(10);
        
        int num = randomNumber % city.getFood().size();
        final String pizza = Pizza.class.getName();
        final String burger = Burger.class.getName();
        final String fries = Fries.class.getName();
        
        
        switch(city.getFood().get(num)){
                case "pizza": return new Pizza();
                
                
                case "burger" : return new Burger();
                
                case "fries":return new Fries();
                
             
          
          
          }
        return null;
        
        
    }
}
