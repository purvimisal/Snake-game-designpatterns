import greenfoot.*;

public class ScoreCard extends Actor implements IScoreRegister {

	private int currentScore = 0;
	private IScoreObserver observer;

	public void updateScoreCard() {

		GreenfootImage img = new GreenfootImage("Score: " + currentScore, 22, Color.BLACK, new Color(0, 0, 0, 0));
		img.setFont(new Font("OptimusPrinceps", false, false, currentScore));
		setImage(img);
	}

	public ScoreCard() {
		updateScoreCard();
	}

	public void act() {

	}

	public void incrementScore() {
		currentScore++;

		updateScoreCard();
		if (currentScore % 5 == 0) {
			notifyController();
		}
	}

	@Override
	public void registerObserver(IScoreObserver observer) {
		this.observer = observer;

	}

	@Override
	public void notifyController() {

		observer.changeState(currentScore);
	}
}
