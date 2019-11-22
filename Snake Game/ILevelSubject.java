/**
 * Write a description of class ILevelSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ILevelSubject  
{
     public void attach(ILevelObserver ob);
     
     public void detach(ILevelObserver ob);
     
     public void notifyObservers(int obstacleInterval, int powerUpInterval,int speed);
}
