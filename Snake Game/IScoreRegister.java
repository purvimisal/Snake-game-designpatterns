
// TODO: Auto-generated Javadoc
/**
 * The Interface IScoreRegister.
 */
public interface IScoreRegister {
	
	/**
	 * Register observer.
	 *
	 * @param observer the observer
	 */
	public void registerObserver(IScoreObserver observer);
	
	/**
	 * Notify controller.
	 */
	public void notifyController();

}
