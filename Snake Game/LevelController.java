import java.util.*;

public class LevelController implements IScoreObserver, ILevelSubject {

    Ilevel level1;
    Ilevel level2;
    Ilevel level3;
    Ilevel gameOver;
    Ilevel current;
    Timer timer;
    List<ILevelObserver> observers;
    public LevelController() {
        current = level1 = new Level1(this);
        level2 = new Level2(this);
        level3 = new Level3(this);
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

    public void changeLevel2() {
        this.current = level2;
        notifyObservers(current.getObstacleTime(),current.getPowerUpTime());
        
    }

    public void changeToLevel1() {
        this.current = level1;
        notifyObservers(current.getObstacleTime(),current.getPowerUpTime());
    }

    public void changeToLevel3() {
         this.current = level3;
         notifyObservers(current.getObstacleTime(),current.getPowerUpTime());
    }

    public void endGame() {
        
    }
    public void attach(ILevelObserver ob) {
        observers.add(ob);
    }
    public void detach(ILevelObserver ob) {
        observers.add(ob);
    }
    public void notifyObservers(int obstacleInterval, int powerUpInterval) {
        for(ILevelObserver ob : observers) {
            ob.update(obstacleInterval,powerUpInterval);
        }
    }
}
