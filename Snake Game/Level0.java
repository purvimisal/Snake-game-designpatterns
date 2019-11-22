import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class Level0 implements Ilevel {

	LevelController controller;
	int obstacleTime;
	int powerUpTime;
	int speed;

	public Level0(LevelController controller) {
		this.obstacleTime = 100;
		this.powerUpTime = 100;
		this.speed = 7;
		this.controller = controller;
	}

	@Override
	public void changeState() {

		controller.changeToLevel1();
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
