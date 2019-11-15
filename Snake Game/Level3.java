

public class Level3 implements Ilevel{

LevelController controller;
public Level3(LevelController controller) {
		this.controller = controller;
	}
	public void changeState() {
		
		controller.endGame();
	}
}
