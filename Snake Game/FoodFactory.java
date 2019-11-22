import java.util.Random;

import greenfoot.*;

public class FoodFactory extends Creators {

	Integer randomNumber = 0;
	Random randomGenerator;

	FoodFactory(){
		randomGenerator = new Random();
	}
	public Actor getItem() {

		randomNumber = randomGenerator.nextInt(10);
		
		if (randomNumber % 3 == 0) {
			return new Burger();
		} else if (randomNumber % 3 == 1) {
			return new Pizza();
		} else {
			return new Fries();

		}
	}
}
