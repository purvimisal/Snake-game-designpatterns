import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class Level5 implements Ilevel {

	LevelController controller;
	int obstacleTime;
	int powerUpTime;
	int speed;

	public Level5(LevelController controller) {
		this.obstacleTime = 15;
		this.powerUpTime = 13;
		this.speed = 3;
		this.controller = controller;
	}

	@Override
	public void changeState() {

		controller.endGame();;
	}

	@Override
	public int getObstacleTime() {

		return obstacleTime;
	}

	@Override
	public int getPowerUpTime() {
		return powerUpTime;

	}
	public int getCurrentSpeed(){
		return speed;
	}
}
