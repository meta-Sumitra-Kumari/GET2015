package Assignment1;

/**
 * @author Sumitra 
 * --Main class to get the instance of singleton class and call its
 *         function
 *
 */
public class SingletonMain {

	public static void main(String[] args) {
		// getting instance
		Singleton singleton = Singleton.getInstance();
		// calling singleton class function using that instance
		singleton.logException();

	}

}
