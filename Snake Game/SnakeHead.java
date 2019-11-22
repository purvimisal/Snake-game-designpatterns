import greenfoot.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class SnakeHead extends Actor implements IFoodPublisher {
	private final int RIGHT = 0;
	private final int DOWN = 90;
	private final int LEFT = 180;
	private final int UP = 270;

	private int SPEED;
	private int counter = 0;
	private int foodConsumed = 0;

	private IScoreObserver observer;
	private ArrayList<IFoodListner> listner;

	public SnakeHead() {
		listner = new ArrayList<>();

		renderSnakeHead();
		getImage().scale(20, 20);
	}

	public void renderSnakeHead() {

		setRotation(Greenfoot.getRandomNumber(4) * 90);
	}

	/**
	 * Attach a Key Pad Observer
	 * 
	 * @param obj Observer
	 */
	public void attach(IFoodListner obj) {
		listner.add(obj);
	}

	/**
	 * Remove Key Pad Observer
	 * 
	 * @param obj Observer
	 */
	public void removeObserver(IFoodListner obj) {
		int i = listner.indexOf(obj);
		if (i >= 0)
			listner.remove(i);
	}

	/**
	 * Notify all Observers of Update Event
	 */
	public void notifyListner() {
		for (int i = 0; i < listner.size(); i++) {
			IFoodListner listner = this.listner.get(i);
			listner.addFoodToWorld();

		}
	}

	public void act() {
		crawl();

		if (!GameOver.isGameOver()) {
			if (isTouching(Food.class)) {
				removeTouching(Food.class);
				foodConsumed++;
				notifyListner();
				Greenfoot.playSound("1.mp3");
			}

			if (isTouching(SnakeBody.class)) {
				gameover();

			}

			if (isTouching(Powerup.class)) {
				Greenfoot.playSound("power.mp3");
				removeTouching(Powerup.class);
				foodConsumed = Math.min((foodConsumed * 2)/3 , foodConsumed - 3);

			}
			if (isTouching(Obstacle.class)) {
				gameover();

			}

			if (getX() < 0) {
				setLocation(getWorld().getWidth() - 1, getY());

			}

			if (getX() > getWorld().getWidth()) {
				setLocation(0, getY());

			}

			if (getY() < 3) {
				setLocation(getX(), getWorld().getHeight() - 1);

			}

			if (getY() > getWorld().getHeight()) {
				setLocation(getX(), 3);

			}
		}

	}

	public void crawl() {
		if (++counter == SPEED) {
			getWorld().addObject(new SnakeBody(foodConsumed * SPEED), getX(), getY());
			move(1);
			counter = 0;
		}

		if (Greenfoot.isKeyDown("up") && getRotation() != DOWN) {
			setRotation(UP);
		}

		if (Greenfoot.isKeyDown("right") && getRotation() != LEFT) {
			setRotation(RIGHT);
		}

		if (Greenfoot.isKeyDown("down") && getRotation() != UP) {
			setRotation(DOWN);
		}

		if (Greenfoot.isKeyDown("left") && getRotation() != RIGHT) {
			setRotation(LEFT);
		}

	}

	public void gameover() {
		GameOver.endGame();

		JOptionPane.showMessageDialog(new JInternalFrame(), "GAME OVER", "Oops!", JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog("Your name:");
		GameOver.writeScores(name, foodConsumed);
		Greenfoot.setWorld(new LeaderBoard());

	}

	public void setSpeed(int speed) {
		this.SPEED = speed;
	}
}
