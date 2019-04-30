public class SmokeDetector extends Sensor {
	protected String serialID;
	protected boolean status;
	protected boolean issueDetected;
	protected int waitTime;

	public SmokeDetector(String serialID, String type) {
		super(serialID, type);
		waitTime = 10;
	}

	public boolean detectIssue() {
		issueDetected = true;
		return issueDetected;
	}

	public void updateReport(String contents) {
		// 
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int val) {
		waitTime = val;
	}
}