// TODO: Auto-generated Javadoc
/**
 * Write a description of class ILevelObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ILevelObserver  
{
    
    /**
     * This method is called when information about an ILevel
     * which was previously requested using an asynchronous
     * interface becomes available.
     *
     * @param obstacleInterval the obstacle interval
     * @param powerUpInterval the power up interval
     * @param speed the speed
     */
    public void update(int obstacleInterval, int powerUpInterval,int speed);
}
