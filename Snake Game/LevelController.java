
public class LevelController implements IScoreObserver {

	Ilevel level1;
	Ilevel level2;
	Ilevel level3;
	Ilevel gameOver;
	Ilevel current;

	public LevelController() {
		
		current = level1 = new Level1(this);
		level2 = new Level2(this);
		level3 = new Level3(this);

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
	}

	public void changeToLevel1() {
		this.current = level1;
	}

	public void changeToLevel3() {
		this.current = level3;
	}

	public void endGame() {

	}

}
