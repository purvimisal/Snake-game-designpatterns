// TODO: Auto-generated Javadoc
/**
 * Write a description of class ILevelSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ILevelSubject  
{
     
     /**
      * Attach.
      *
      * @param ob the ob
      */
     public void attach(ILevelObserver ob);
     
     /**
      * Detach.
      *
      * @param ob the ob
      */
     public void detach(ILevelObserver ob);
     
     /**
      * Notify observers.
      *
      * @param obstacleInterval the obstacle interval
      * @param powerUpInterval the power up interval
      * @param speed the speed
      */
     public void notifyObservers(int obstacleInterval, int powerUpInterval,int speed);
}
