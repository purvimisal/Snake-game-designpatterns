import java.util.*;

public class LevelController implements IScoreObserver, ILevelSubject {

	Ilevel level0;
	Ilevel level1;
	Ilevel level2;
	Ilevel level3;
	Ilevel level4;
	Ilevel level5;
	Ilevel gameOver;
	Ilevel current;
	Timer timer;
	public Integer speed;
	List<ILevelObserver> observers;

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

	@Override
	public void changeState(Integer score) {
		current.changeState();
	}

	public String getState() {
		return current.getClass().getName();
	}

	public void changeToLevel0() {
		this.current = level0;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	public void changeToLevel1() {
		this.current = level1;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	public void changeToLevel2() {
		this.current = level2;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());

	}

	public void changeToLevel3() {
		this.current = level3;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	public void endGame() {

	}

	public void attach(ILevelObserver ob) {
		observers.add(ob);
	}

	public void detach(ILevelObserver ob) {
		observers.add(ob);
	}

	public void notifyObservers(int obstacleInterval, int powerUpInterval,int speed) {
		for (ILevelObserver ob : observers) {
			ob.update(obstacleInterval, powerUpInterval,speed);
		}
	}

	public void changeToLevel4() {
		this.current = level4;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}

	public void changeToLevel5() {
		this.current = level5;
		notifyObservers(current.getObstacleTime(), current.getPowerUpTime(),current.getCurrentSpeed());
	}


}
