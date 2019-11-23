import greenfoot.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class SnakeHead.
 */
public class SnakeHead extends Actor implements IFoodPublisher {
	
	/** The right. */
	private final int RIGHT = 0;
	
	/** The down. */
	private final int DOWN = 90;
	
	/** The left. */
	private final int LEFT = 180;
	
	/** The up. */
	private final int UP = 270;

	/** The speed. */
	private int SPEED;
	
	/** The counter. */
	private int counter = 0;
	
	/** The snake length. */
	private int snakeLength =0;
	
	/** The food consumed. */
	private int foodConsumed = 0;

	/** The observer. */
	private IScoreObserver observer;
	
	/** The listner. */
	private ArrayList<IFoodListner> listner;

	/**
	 * Instantiates a new snake head.
	 */
	public SnakeHead() {
		listner = new ArrayList<>();

		renderSnakeHead();
		getImage().scale(20, 20);
	}

	/**
	 * Render snake head.
	 */
	public void renderSnakeHead() {

		setRotation(Greenfoot.getRandomNumber(4) * 90);
	}

	/**
	 * Attach a Key Pad Observer.
	 *
	 * @param obj Observer
	 */
	public void attach(IFoodListner obj) {
		listner.add(obj);
	}

	/**
	 * Remove Key Pad Observer.
	 *
	 * @param obj Observer
	 */
	public void removeObserver(IFoodListner obj) {
		int i = listner.indexOf(obj);
		if (i >= 0)
			listner.remove(i);
	}

	/**
	 * Notify all Observers of Update Event.
	 */
	public void notifyListner() {
		for (int i = 0; i < listner.size(); i++) {
			IFoodListner listner = this.listner.get(i);
			listner.addFoodToWorld();

		}
	}

	/**
	 * Act.
	 */
	public void act() {
		crawl();

		if (!GameOver.isGameOver()) {
			if (isTouching(Food.class)) {
				removeTouching(Food.class);
				snakeLength++;
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
				snakeLength = (snakeLength * 2) / 3;

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

	/**
	 * Crawl.
	 */
	public void crawl() {
		if (++counter == SPEED) {
			getWorld().addObject(new SnakeBody(snakeLength * SPEED), getX(), getY());
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

	/**
	 * Gameover.
	 */
	public void gameover() {
		GameOver.endGame();

		JOptionPane.showMessageDialog(new JInternalFrame(), "GAME OVER", "Oops!", JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog("Your name:");
		GameOver.writeScores(name, foodConsumed);
		Greenfoot.setWorld(new LeaderBoard());

	}

	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(int speed) {
		this.SPEED = speed;
	}
}
