
public class Alaska implements ICities {

	private String image;
	private String name;

	public Alaska(String image, String name) {
		this.image = image;
		this.name = name;
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

}
