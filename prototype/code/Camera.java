public class Camera extends Sensor {

   protected String serialID;
   protected boolean status;
   protected boolean issueDetected;
   protected boolean motionDetected;

   public Camera(String serialID, String type) {
      super(serialID, type);
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
   	System.out.println(contents);
   }
   
   public boolean getIssueDetected() {
      return issueDetected;
   }
}
