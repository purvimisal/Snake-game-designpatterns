import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Bangalore.
 */
public class Bangalore implements ICities{
	

	/** The image. */
	private String image;
	
	/** The name. */
	private String name;
	
	/** The foods. */
	private List<String> foods;

	/**
	 * Instantiates a new bangalore.
	 *
	 * @param image the image
	 * @param name the name
	 */
	public Bangalore(String image, String name) {
		this.image = image;
		this.name = name;
			foods = new ArrayList();
		foods.add("burger");
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	/**
	 * Gets the food.
	 *
	 * @return the food
	 */
	@Override
	public List getFood(){
		return foods;
	}
}
