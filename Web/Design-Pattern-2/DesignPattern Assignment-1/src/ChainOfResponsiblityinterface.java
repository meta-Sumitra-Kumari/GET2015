import java.util.Scanner;

/**
 * @author Sumitra
 * 
 * Main class to set the chain of responsibility
 *
 */
public class ChainOfResponsiblityinterface {

	public static void main(String[] args) {
		// creating objects of approvers
		Approver objectMentor = new Mentor();
		Approver objectSeniorMentor = new SeniorMentor();
		Approver objectHrManager = new HrManager();
		// setting successor
		objectMentor.SetSuccessor(objectSeniorMentor);
		objectSeniorMentor.SetSuccessor(objectHrManager);
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter number of days of leave");
		int leave = scanner.nextInt();
		// starting from mentor
		objectMentor.ProcessRequest(leave);
		scanner.close();
	}

}