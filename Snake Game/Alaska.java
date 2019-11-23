import java.util.*;
public class Alaska implements ICities {

	private String image;
	private String name;
	private List<String> foods;

	public Alaska(String image, String name) {
		this.image = image;
		this.name = name;
			foods = new ArrayList();
			foods.add("fries");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	
	@Override
	public List getFood(){
		return foods;
	}

}
