
public class Level3 implements Ilevel {

	LevelController controller;

	int obstacleTime;
	int powerUpTime;

	public Level3(LevelController controller) {
		this.powerUpTime = 7;
		this.obstacleTime = 35;
		this.controller = controller;
	}

	public void changeState() {

		controller.endGame();
	}

	@Override
	public int getObstacleTime() {

		return obstacleTime;
	}

	@Override
	public int getPowerUpTime() {

		return powerUpTime;
	}

}
