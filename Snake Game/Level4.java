import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class Level4.
 */
public class Level4 implements Ilevel {

	/** The controller. */
	LevelController controller;
	
	/** The obstacle time. */
	int obstacleTime;
	
	/** The power up time. */
	int powerUpTime;
	
	/** The speed. */
	int speed;

	/**
	 * Instantiates a new level 4.
	 *
	 * @param controller the controller
	 */
	public Level4(LevelController controller) {
		this.obstacleTime = 14;
		this.powerUpTime = 12;
		this.speed = 5;
		this.controller = controller;
	}

	/**
	 * Change state.
	 */
	@Override
	public void changeState() {

		controller.changeToLevel5();
	}

	/**
	 * Gets the obstacle time.
	 *
	 * @return the obstacle time
	 */
	@Override
	public int getObstacleTime() {

		return obstacleTime;
	}

	/**
	 * Gets the power up time.
	 *
	 * @return the power up time
	 */
	@Override
	public int getPowerUpTime() {
		return powerUpTime;

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
