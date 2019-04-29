public abstract class Sensor {
   protected String serialID;
   protected boolean status;
   protected boolean issueDetected;
   
   public Sensor(String serialID) {
      this.serialID = serialID;
      issueDetected = false;
      status = true;
   }
   
   public abstract boolean detectIssue();

   public abstract void updateReport(String contents);
   
   public String getSerialID() {
      return serialID;
   }
}