import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class Level1 implements Ilevel {

	LevelController controller;
	int obstacleTime;
	int powerUpTime;

	public Level1(LevelController controller) {
		this.obstacleTime = 1;
		this.powerUpTime = 100;
		this.controller = controller;
	}

	@Override
	public void changeState() {
		JOptionPane.showMessageDialog(new JInternalFrame(), "Level2", "Congrats!", JOptionPane.INFORMATION_MESSAGE);
		// System.out.println("level1 to level2");
		controller.changeLevel2();
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
