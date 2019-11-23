
// TODO: Auto-generated Javadoc
/**
 * The Class Level3.
 */
public class Level3 implements Ilevel {

    /** The controller. */
    LevelController controller;
    
    /** The speed. */
    int speed;
    
    /** The obstacle time. */
    int obstacleTime;
    
    /** The power up time. */
    int powerUpTime;

    /**
     * Instantiates a new level 3.
     *
     * @param controller the controller
     */
    public Level3(LevelController controller) {
        this.powerUpTime = 15;
        this.obstacleTime = 11;
        this.speed = 6;
        this.controller = controller;
    }

    /**
     * Change state.
     */
    public void changeState() {

        controller.changeToLevel4();
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
