public class Report {
   private String contents;
   private int reportID;
   
   public Report(String contents, int reportID) {
      this.contents = contents;
      this.reportID = reportID;
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

