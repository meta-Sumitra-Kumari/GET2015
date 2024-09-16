import java.sql.Timestamp;

/**
 * @author Sumitra --- abstract class vehicle to store data of general vehicle
 *
 */
public abstract class Vehicle {
	private int vehicleId;
	private String make;
	private String model;
	private double engineInCC;
	private double fuelCapacity;
	private double milage;
	private double price;
	private double roadTax;
	private Timestamp createdTime;
	private String createdBy;

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the engineInCC
	 */
	public double getEngineInCC() {
		return engineInCC;
	}

	/**
	 * @param d
	 *            the engineInCC to set
	 */
	public void setEngineInCC(double d) {
		this.engineInCC = d;
	}

	/**
	 * @return the fuelCapacity
	 */
	public double getFuelCapacity() {
		return fuelCapacity;
	}

	/**
	 * @param fuelCapacity
	 *            the fuelCapacity to set
	 */
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	/**
	 * @return the milage
	 */
	public double getMilage() {
		return milage;
	}

	/**
	 * @param milage
	 *            the milage to set
	 */
	public void setMilage(double milage) {
		this.milage = milage;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the roadTax
	 */
	public double getRoadTax() {
		return roadTax;
	}

	/**
	 * @param roadTax
	 *            the roadTax to set
	 */
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	public String toString() {
		return "make:" + getMake() + "," + "model:" + getModel();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId
	 *            the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the createdTime
	 */
	public Timestamp getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 *            the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy() {
		if(this.model.equalsIgnoreCase("model1")||this.model.equalsIgnoreCase("model3")||this.model.equalsIgnoreCase("model5"))
		this.createdBy = "honda";
		else 
			this.createdBy="maruti";
	}

}
