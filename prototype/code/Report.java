public class Report {
   private String contents;
   private int reportID;
   
   public Report() {
      contents = "";
      reportID = 0;
   }
   
   public String getContents() {
      return contents;
   }
   
   public void setContents(String newContents) {
      contents = newContents;
   }  
   
   public int getReportID() {
      return reportID;
   }
   
   public void setReportId(int newReportID) {
      reportID = newReportID;
   }
}
