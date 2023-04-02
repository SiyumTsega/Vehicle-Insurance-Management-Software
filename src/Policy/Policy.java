package Policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable{

	
	static int PolicyNB = 0;
	
	Vehicle vehicle;
	
	List  <String> risksCoveredList = new ArrayList<>();
	
	List<Float> premeiumList = new ArrayList<>();
	List<Float> coverageList = new ArrayList<>();
	List<Float> ceilingList = new ArrayList<>();
	
	int validityYear;
	LocalDate policyDate;
	public Policy(Vehicle vehicle, List<String> risksCoveredList, List<Float> premeiumList, List<Float> coverageList,
			List<Float> ceilingList, int validityYear, LocalDate policyDate) {
		super();
		this.vehicle = vehicle;
		this.risksCoveredList = risksCoveredList;
		this.premeiumList = premeiumList;
		this.coverageList = coverageList;
		this.ceilingList = ceilingList;
		this.validityYear = validityYear;
		this.policyDate = policyDate;
		
		PolicyNB +=1;
		
		
	}
	public static int getPolicyNB() {
		return PolicyNB;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public List<String> getRisksCoveredList() {
		return risksCoveredList;
	}
	public List<Float> getPremeiumList() {
		return premeiumList;
	}
	public List<Float> getCoverageList() {
		return coverageList;
	}
	public List<Float> getCeilingList() {
		return ceilingList;
	}
	public int getValidityYear() {
		return validityYear;
	}
	public LocalDate getPolicyDate() {
		return policyDate;
	}
	@Override
	public String toString() {
		return "Policy NB" + PolicyNB + 
				'\n' + vehicle +
				"\nValidityYear" + validityYear;
	}
	
}
