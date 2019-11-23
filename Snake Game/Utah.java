import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Utah.
 */
public class Utah implements ICities {

	/** The image. */
	private String image;
	
	/** The name. */
	private String name;
	
	/** The foods. */
	private List<String> foods;

	/**
	 * Instantiates a new utah.
	 *
	 * @param image the image
	 * @param name the name
	 */
	public Utah(String image, String name) {
		this.image = image;
		this.name = name;
		foods = new ArrayList();
		foods.add("burger");
		foods.add("pizza");
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() {
		
		return name;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public String getImage() {
		
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
