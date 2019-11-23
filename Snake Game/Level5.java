import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class Level5.
 */
public class Level5 implements Ilevel {

	/** The controller. */
	LevelController controller;
	
	/** The obstacle time. */
	int obstacleTime;
	
	/** The power up time. */
	int powerUpTime;
	
	/** The speed. */
	int speed;

	/**
	 * Instantiates a new level 5.
	 *
	 * @param controller the controller
	 */
	public Level5(LevelController controller) {
		this.obstacleTime = 12;
		this.powerUpTime = 13;
		this.speed = 3;
		this.controller = controller;
	}

	/**
	 * Change state.
	 */
	@Override
	public void changeState() {

		controller.endGame();;
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
