
public interface IScoreRegister {
	
	public void registerObserver(IScoreObserver observer);
	public void notifyController();

}
