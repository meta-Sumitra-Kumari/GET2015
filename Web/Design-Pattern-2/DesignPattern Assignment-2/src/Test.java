
/**
 * @author Sumitra
 *
 */
public class Test  extends Game
{
	/* (non-Javadoc)
	 * @see Game#endPlay()
	 * rules of end play
	 */
	@Override
	void endPlay() 
	{
		System.out.println("Team B was not able to chase the run so match was Drawn");
		System.out.println("Cricket Game Finished!");
	}



	/* (non-Javadoc)
	 * @see Game#startPlay()
	 * rules of start play
	 */
	@Override
	void startPlay() {
		System.out.println("Toss performed. Team A won the toss.");
		System.out.println("Team A elected to bat first");
		System.out.println("Game is now starting.");
	}
}
