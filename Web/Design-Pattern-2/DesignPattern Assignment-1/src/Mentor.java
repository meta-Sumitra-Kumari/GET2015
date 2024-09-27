/**
 * @author Sumitra
 * --Class mentor whose object can approve leave for one day
 *
 */
public class Mentor extends Approver {

	@Override
	public void ProcessRequest(int noOfDays) {// checking for no of days of
												// leave
		if (noOfDays == 1) {
			System.out.println("1 Day Leave GRanted by mentor");
		} else if (successor != null) {
			successor.ProcessRequest(noOfDays);
		}

	}

}
