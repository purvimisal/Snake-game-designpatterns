
public class Level3 implements Ilevel {

    LevelController controller;
    int speed;
    int obstacleTime;
    int powerUpTime;

    public Level3(LevelController controller) {
        this.powerUpTime = 10;
        this.obstacleTime = 12;
        this.speed = 6;
        this.controller = controller;
    }

    public void changeState() {

        controller.changeToLevel4();
    }

    @Override
    public int getObstacleTime() {

        return obstacleTime;
    }

    @Override
    public int getPowerUpTime() {

        return powerUpTime;
    }
    public int getCurrentSpeed(){
        return speed;
    }

}
