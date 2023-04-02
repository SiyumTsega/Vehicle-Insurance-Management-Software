package Plan;

public abstract class Risk {
	
	float premium;
	float coverage;
	float ceiling;
	
	public boolean isCovered(String[] risksCovered, String [] claimed) {
		
		int i = 0;
		int j = 0;
		for (i = 0; i < claimed.length; i++) {
			for(j = 0; j < risksCovered.length; j++) {
				if(claimed[i] == risksCovered[j]) {
					break;
				}
				
				if(j == risksCovered.length) {
					return false;
				}
			}
		}
		
		return true;
	}

	public abstract float getPremium();
	public abstract float getCoverage();
	public abstract float getCeiling();
	
}
