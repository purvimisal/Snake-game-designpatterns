import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class Level1.
 */
public class Level1 implements Ilevel {

	/** The controller. */
	LevelController controller;
	
	/** The obstacle time. */
	int obstacleTime;
	
	/** The power up time. */
	int powerUpTime;
	
	/** The speed. */
	int speed;
	
	/**
	 * Instantiates a new level 1.
	 *
	 * @param controller the controller
	 */
	public Level1(LevelController controller) {
		this.obstacleTime = 7;
		this.powerUpTime = 17;
		this.controller = controller;
		this.speed = 8;
	}

	/**
	 * Change state.
	 */
	@Override
	public void changeState() {

		controller.changeToLevel2();
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
