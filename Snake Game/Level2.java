import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
public class Level2 implements Ilevel {

	LevelController controller;
	int speed;
	int obstacleTime;
	int powerUpTime;
	
	public Level2(LevelController controller) {
		this.controller = controller;
		this.obstacleTime = 8;
		this.powerUpTime = 10;
		this.speed = 7;
	}



	public void changeState() {
		//JOptionPane.showMessageDialog(null, "Level3","Congrats!", JOptionPane.INFORMATION_MESSAGE);
		controller.changeToLevel3();
	}

	public int getObstacleTime() {
		return powerUpTime;
	}
	
	public int getPowerUpTime() {
		return obstacleTime;
	}
	public int getCurrentSpeed(){
		return speed;
	}

}
