public class MotionSensor extends Sensor {

    protected String serialID;
    protected boolean status;
    protected boolean issueDetected;
    protected String type;

    public MotionSensor(String serialID, String type) {
    	super(serialID, type);
    }

	public boolean detectIssue() {
		issueDetected = true;
		return issueDetected;
	}

	public void updateReport(String contents) {
		// 
	}
}