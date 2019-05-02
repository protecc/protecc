import java.util.Arrays;

public class ReportList {
   private Report[] reportList;
   
   public ReportList() {
      reportList = new Report[0];
   }
   
   public void add(String contents, int reportID) {
      reportList = Arrays.copyOf(reportList, reportList.length + 1);
      reportList[sensorList.length - 1] = new Report(contents, reportID);
      System.out.println("Report " + reportID + " added.");
   }
   
   public void remove(String reportID) {
      int index = 0;
      
      for (Report report : reportList) {
         if (sensor.reportID.equals(reportID)) {
            Report[] updatedList = new Report[reportList.length-1];
            System.arraycopy(reportList, 0, updatedList, 0, index);
            System.arraycopy(reportList, index + 1, updatedList, index, reportList.length - index - 1);
            System.out.println("Report removed");
            reportList = updatedList;
            return;
         }
         index += 1;
      }
      System.out.println("Error - report not found.");
   }
   
   public Report getReport(String reportID) {
      for (Report report : reportList) {
         if (report.reportID.equals(reportID)) {
            return report;
         }
      }
      return null;
   }
   
   public Report[] getList() {
      return reportList;
   }
}
