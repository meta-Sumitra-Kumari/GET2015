/**
 * @author Sumitra--- Class bike extends Vehicle class
 *
 */
public class Bike extends Vehicle {
	private Boolean selfStart;
	private double helmetPrice;

	// getters and setters
	/**
	 * @return the selfStart
	 */
	public Boolean getSelfStart() {
		return selfStart;
	}

	/**
	 * @param selfStart
	 *            the selfStart to set
	 */
	public void setSelfStart(Boolean selfStart) {
		this.selfStart = selfStart;
	}

	/**
	 * @return the helmetPrice
	 */
	public double getHelmetPrice() {
		return helmetPrice;
	}

	/**
	 * @param helmetPrice
	 *            the helmetPrice to set
	 */
	public void setHelmetPrice(double helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

}
