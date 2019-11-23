import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
// TODO: Auto-generated Javadoc

/**
 * The Class Level2.
 */
public class Level2 implements Ilevel {

	/** The controller. */
	LevelController controller;
	
	/** The speed. */
	int speed;
	
	/** The obstacle time. */
	int obstacleTime;
	
	/** The power up time. */
	int powerUpTime;
	
	/**
	 * Instantiates a new level 2.
	 *
	 * @param controller the controller
	 */
	public Level2(LevelController controller) {
		this.controller = controller;
		this.obstacleTime = 9;
		this.powerUpTime = 16;
		this.speed = 7;
	}



	/**
	 * Change state.
	 */
	public void changeState() {
		//JOptionPane.showMessageDialog(null, "Level3","Congrats!", JOptionPane.INFORMATION_MESSAGE);
		controller.changeToLevel3();
	}

	/**
	 * Gets the obstacle time.
	 *
	 * @return the obstacle time
	 */
	public int getObstacleTime() {
		return powerUpTime;
	}
	
	/**
	 * Gets the power up time.
	 *
	 * @return the power up time
	 */
	public int getPowerUpTime() {
		return obstacleTime;
	}
	
	/**
	 * Gets the current speed.
	 *
	 * @return the current speed
	 */
	public int getCurrentSpeed(){
		return speed;
	}

}
