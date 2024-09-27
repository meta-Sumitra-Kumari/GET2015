/**
 * @author Sumitra
 * ----Class senior mentor whose object can approve leave for two
 *         days or less
 *
 */
public class SeniorMentor extends Approver {

	@Override
	public void ProcessRequest(int noOfDays) {// checking for no of days of
												// leave
		if (noOfDays <= 2) {
			System.out.println(" Leave GRanted by  Senior mentor");
		} else if (successor != null) {
			successor.ProcessRequest(noOfDays);
		}

	}

}