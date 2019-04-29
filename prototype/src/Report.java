public class Report {
   private String contents;
   private String reportID;
   
   public Report(String reportID) {
      contents = "";
      this.reportID = reportID;
   }
   
   public String getContents() {
      return contents;
   }
   
   public void setContents(String newContents) {
      contents = newContents;
   }
   
   public String getReportID() {
      return reportID;
   }
}