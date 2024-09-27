/**
 * @author Sumitra
 *
 */
abstract class Approver {
	protected Approver successor;

	/**
	 * function to set successor
	 * 
	 * @param successor
	 */
	public void SetSuccessor(Approver successor) {
		this.successor = successor;
	}

	/**
	 * function to approve leave
	 * 
	 * @param noOfDays
	 */
	public abstract void ProcessRequest(int noOfDays);
}