/**
 * @author Sumitra
 *
 */
public abstract class Game {
	/**
	 * Function to initialize the game --checking for status --can play or not
	 * 
	 * @param noOfTeams
	 *            --no of teams that can play
	 * @param noOfPlayers
	 *            --no of players playing
	 * @return--true if all conditions are true else false
	 */
	boolean initialize(int noOfTeams, int noOfPlayers) {
		boolean flag = false;
		if (noOfTeams != 2) {
			System.out.println("only 2 teams can play.");
		}
		if (noOfPlayers != 11) {
			System.out.println("not exact members in the team.");
		} else if ((noOfTeams == 2) && (noOfPlayers == 11)) {
			System.out.println("game is ready to start.");
			flag = true;
		}

		return flag;

	}

	/**
	 * according to the inherited class
	 */
	abstract void startPlay();

	/**
	 * according to the inherited class
	 */
	abstract void endPlay();

	/**
	 * template method ---to set the rules ---start and end the game
	 * 
	 * @param noOfTeams
	 * @param noOfPlayers
	 */
	public final void play(int noOfTeams, int noOfPlayers) {

		// initialize the game
		if (initialize(noOfTeams, noOfPlayers)) {

			// start game
			startPlay();

			// end game
			endPlay();
		}
	}
}
