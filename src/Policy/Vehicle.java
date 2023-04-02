package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable{

	
	int plateNb;
	int modelYear;
	String manufacture;
	int estimatedValue;
	int carDamage;
	public Vehicle(int plateNb, int modelYear, String manufacture, int estimatedValue, int carDamage) {
		super();
		this.plateNb = plateNb;
		this.modelYear = modelYear;
		this.manufacture = manufacture;
		this.estimatedValue = estimatedValue;
		this.carDamage = carDamage;
	}
	public int getPlateNb() {
		return plateNb;
	}
	public void setPlateNb(int plateNb) {
		this.plateNb = plateNb;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getEstimatedValue() {
		return estimatedValue;
	}
	public void setEstimatedValue(int estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
	public int getCarDamage() {
		return carDamage;
	}
	public void setCarDamage(int carDamage) {
		this.carDamage = carDamage;
	}
	@Override
	public String toString() {
		return "plateNb=" + plateNb + 
				"\nmodelYear=" + modelYear +
				"\nmanufacture=" + manufacture+
				"\nestimatedValue=" + estimatedValue + 
				"\ncarDamage=" + carDamage;
	}
	
	
}
