/**
 * @author Sumitra
 * class HrManager which can grant leave,if it is for less than 5
 *         days
 *
 */
public class HrManager extends Approver {

	@Override
	public void ProcessRequest(int noOfDays) {// checking days of leave request
		if (noOfDays <= 5) {
			System.out.println(" Leave GRanted by  Hr manager ");
		} else {
			System.out.println("valid reasons should be provided");
		}

	}

}