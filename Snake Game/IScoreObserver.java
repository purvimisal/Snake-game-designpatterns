
// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications
 * about IScore information as the IScore is constructed.
 */
public interface IScoreObserver {

	/**
	 * This method is called when information about an IScore
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param score the score
	 */
	void changeState(Integer score);
}
