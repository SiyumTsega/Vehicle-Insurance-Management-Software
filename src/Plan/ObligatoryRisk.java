package Plan;

public class ObligatoryRisk extends Risk{

	@Override
	public float getPremium() {
		// TODO Auto-generated method stub
		return 0.01f;
	}

	@Override
	public float getCoverage() {
		// TODO Auto-generated method stub
		return 0.6f;
	}

	@Override
	public float getCeiling() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	public String[] obligatoryRisksCovered = {
			"Third Party Damage"
	};

}
