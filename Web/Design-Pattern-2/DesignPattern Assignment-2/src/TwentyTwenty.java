
/**
 * @author Sumitra
 *
 */
public class TwentyTwenty extends Game
{
	
	/* (non-Javadoc)
	 * @see Game#endPlay()
	 * 
	 * rules of end play
	 */
	@Override
	void endPlay() 
	{
		System.out.println("Team B chased the Required  runs and won the Match");
		System.out.println("Cricket Game Finished!");
	}



	/* (non-Javadoc)
	 * @see Game#startPlay()
	 * 
	 * rules of start play
	 */
	@Override
	void startPlay()
	{
		System.out.println("Toss performed. Team A won the toss.");
		System.out.println("Team A elected to bat first");
		System.out.println("Game is now starting.");
	}
}