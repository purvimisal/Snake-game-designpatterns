import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class Level4 implements Ilevel {

	LevelController controller;
	int obstacleTime;
	int powerUpTime;
	int speed;

	public Level4(LevelController controller) {
		this.obstacleTime = 13;
		this.powerUpTime = 8;
		this.speed = 5;
		this.controller = controller;
	}

	@Override
	public void changeState() {

		controller.changeToLevel5();
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
