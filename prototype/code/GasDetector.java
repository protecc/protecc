public class GasDetector extends Sensor {

	protected String serialID;
	protected boolean status;
	protected boolean issueDetected;
	protected double permittedLevel;
	protected double currentLevel;

	public GasDetector(String serialID, String type) {
		super(serialID, type);
		permittedLevel = 10;
		currentLevel = 0;
	}

	public boolean detectIssue() {
		issueDetected = true;
		return issueDetected;
	}

	public void updateReport(String contents) {
		// 
	}
   

	public boolean getIssueDetected() {
		return issueDetected;
	}

	public double getPermittedLevel() {
		return permittedLevel;
	}

	public void setPermittedLevel(double val) {
		permittedLevel = val;
	} 

	public double getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(double val) {
		currentLevel = val;
	}
}