public class Camera extends Sensor {

   protected String serialID;
   protected boolean status;
   protected boolean issueDetected;
   protected boolean motionDetected;

   public Camera(String inputSerialID, String type) {
      super(inputSerialID, type);
      motionDetected = false;
   }

   public boolean detectIssue() {
      issueDetected = true;
      return issueDetected;
   }

   public boolean detectMotion() {
      motionDetected = true;
      return motionDetected;
   }

   public void updateReport(String contents) {
   	// 
   }
   
   public String getSerialID() {
      return this.serialID;
   }

   public boolean getIssueDetected() {
      return issueDetected;
   }
}