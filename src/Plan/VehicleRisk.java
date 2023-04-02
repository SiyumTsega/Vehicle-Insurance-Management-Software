package Plan;

public class VehicleRisk extends Risk{

	@Override
	public float getPremium() {
		// TODO Auto-generated method stub
		return 0.05f;
	}

	@Override
	public float getCoverage() {
		// TODO Auto-generated method stub
		return 0.9f;
	}

	@Override
	public float getCeiling() {
		// TODO Auto-generated method stub
		return 6;
	}
 
	public String[] vehicleRisksCovered = {
			"Vehicle Damage"
	};
	 
	
}
