import java.util.*;
public class Utah implements ICities {

	private String image;
	private String name;
	private List<String> foods;

	public Utah(String image, String name) {
		this.image = image;
		this.name = name;
		foods = new ArrayList();
		foods.add("burger");
		foods.add("pizza");
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public String getImage() {
		
		return image;
	}

	@Override
	public List getFood(){
		return foods;
	}
}
