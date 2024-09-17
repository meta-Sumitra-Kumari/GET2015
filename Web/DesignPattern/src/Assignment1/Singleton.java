package Assignment1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Sumitra
 * --Singleton class for creating exception log and storing it
 *
 */
public class Singleton {

	private static Singleton singleton = new Singleton();

	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private Singleton() {
	}

	/* Static 'instance' method to get the instance */
	public static Singleton getInstance() {
		return singleton;
	}

	/**
	 * Function to create exception and storing it in a log file
	 */
	protected void logException() {

		Logger logger = Logger.getLogger("MyLog");
		String name = logger.getName();
		System.out.println("Logger name: " + name);
		// The FileHandler can either write to a specified file, or it can write
		// to a rotating set of files
		FileHandler fh;

		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler(
					"C:/Users/Sumitra/workspace/advancejava/DesignPattern/MyLogFile.log");
			// Add a log Handler to receive logging messages.
			logger.addHandler(fh);

			// Print a brief summary of the LogRecord in a human readable
			// format.
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages

			logger.info("My first log");
			int value = 5 / 0;

		} catch (ArithmeticException e) {
			logger.info("Threw a ArithmeticException in LoggerFile::full stack trace follows:"
					+ e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
