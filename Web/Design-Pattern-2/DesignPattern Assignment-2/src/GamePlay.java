import java.util.Scanner;

/**
 * @author Sumitra
 *
 */
public class GamePlay {

	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 50 Overs For OneDay\n Enter 20 Overs For Twenty Twenty \n Enter 450 Overs For Test");
		System.out.println("Enter Total No of Overs");
		int overs = scanner.nextInt();
		System.out.println("enter No of Teams");
		int noOfTeams=scanner.nextInt();
		System.out.println("Enter No Of players");
		int noOfPlayers=scanner.nextInt();
		//checking conditions
		if (overs == 50) {
			Game game = new OneDay();
			game.play(noOfTeams, noOfPlayers);
		} else if (overs == 20) {
			Game game = new TwentyTwenty();
			game.play(noOfTeams, noOfPlayers);
		} else if (overs == 450) {
			Game game = new Test();
			game.play(noOfTeams, noOfPlayers);
		}
		else
		{
			System.out.println("Enter Correct format ");
		}
		scanner.close();
	}
}
