import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class LevelController.
 */
public class LevelController implements IScoreObserver, ILevelSubject {

	/** The level 0. */
	Ilevel level0;
	
	/** The level 1. */
	Ilevel level1;
	
	/** The level 2. */
	Ilevel level2;
	
	/** The level 3. */
	Ilevel level3;
	
	/** The level 4. */
	Ilevel level4;
	
	/** The level 5. */
	Ilevel level5;
	
	/** The game over. */
	Ilevel gameOver;
	
	/** The current. */
	Ilevel current;
	
	/** The timer. */
	Timer timer;
	
	/** The speed. */
	public Integer speed;
	
	/** The observers. */
	List<ILevelObserver> observers;

	/**
	 * Instantiates a new level controller.
	 */
	public LevelController() {

		level0 = new Level0(this);
		level1 = new Level1(this);
		level2 = new Level2(this);
		level3 = new Level3(this);
		level4 = new Level4(this);
		level5 = new Level5(this);
		observers = new ArrayList<ILevelObserver>();
		timer = new Timer();
	}

	/**
	 * Change state.
	 *
	 * @param score the score
	 */
	@Override
	public void changeState(Integer score) {
		current.changeState();
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return current.getClass().getName();
	}

	/**
	 * Change to level 0.
	 */
	public void changeToLevel0() {
		this.current = level0;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	/**
	 * Change to level 1.
	 */
	public void changeToLevel1() {
		this.current = level1;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	/**
	 * Change to level 2.
	 */
	public void changeToLevel2() {
		this.current = level2;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());

	}

	/**
	 * Change to level 3.
	 */
	public void changeToLevel3() {
		this.current = level3;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	/**
	 * End game.
	 */
	public void endGame() {

	}

	/**
	 * Attach.
	 *
	 * @param ob the ob
	 */
	public void attach(ILevelObserver ob) {
		observers.add(ob);
	}

	/**
	 * Detach.
	 *
	 * @param ob the ob
	 */
	public void detach(ILevelObserver ob) {
		observers.add(ob);
	}

	/**
	 * Notify observers.
	 *
	 * @param obstacleInterval the obstacle interval
	 * @param powerUpInterval the power up interval
	 * @param speed the speed
	 */
	public void notifyObservers(int obstacleInterval, int powerUpInterval,int speed) {
		for (ILevelObserver ob : observers) {
			ob.update(obstacleInterval, powerUpInterval,speed);
		}
	}

	/**
	 * Change to level 4.
	 */
	public void changeToLevel4() {
		this.current = level4;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	/**
	 * Change to level 5.
	 */
	public void changeToLevel5() {
		this.current = level5;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}


}
