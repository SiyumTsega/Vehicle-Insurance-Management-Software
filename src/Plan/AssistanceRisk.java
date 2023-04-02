package Plan;

public class AssistanceRisk extends Risk{

	@Override
	public float getPremium() {
		// TODO Auto-generated method stub
		return 0.05f;
	}

	@Override
	public float getCoverage() {
		// TODO Auto-generated method stub
		return 0.8f;
	}

	@Override
	public float getCeiling() {
		// TODO Auto-generated method stub
		return 8;
	}

	public String[] assistanceRisksCovered = {
			"Fire",
			"Robber",
			"Transport",
			"Car Replaceement"
	};
}
