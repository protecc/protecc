public abstract class Sensor {
   protected String serialID;
   protected boolean status;
   protected boolean issueDetected;
   protected String type;
   
   public Sensor(String serialID, String type) {
      this.serialID = serialID;
      issueDetected = false;
      status = true;
      type = type;
   }
   
   public abstract boolean detectIssue();

   public abstract void updateReport(String contents);
   
   public String getSerialID() {
      return this.serialID;
   }

   public boolean getIssueDetected() {
      return issueDetected;
   }
}