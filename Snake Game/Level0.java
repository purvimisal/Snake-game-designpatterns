import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class Level0.
 */
public class Level0 implements Ilevel {

	/** The controller. */
	LevelController controller;
	
	/** The obstacle time. */
	int obstacleTime;
	
	/** The power up time. */
	int powerUpTime;
	
	/** The speed. */
	int speed;

	/**
	 * Instantiates a new level 0.
	 *
	 * @param controller the controller
	 */
	public Level0(LevelController controller) {
		this.obstacleTime = 7;
		this.powerUpTime = 14;
		this.speed = 7;
		this.controller = controller;
	}

	/**
	 * Change state.
	 */
	@Override
	public void changeState() {

		controller.changeToLevel1();
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
