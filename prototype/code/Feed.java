public class Feed {

   protected String serialID;

   public String showFeed(String serialID, SensorList sensorList) {
   
      String feedString;
      Sensor sensor = sensorList.getSensor(serialID);
      
      if (sensor != null)
      {
         if (sensor.getIssueDetected()) {
            feedString = "Showing feed for sensor with serial ID "
               + serialID + ": There was an issue detected. ";
            return feedString;
         }
         else {
            feedString = "Showing feed for sensor with serial ID "
               + serialID + ": There are no issues detected. ";
            return feedString;
         }
      }
      else {
         feedString = "Sensor with serial ID " + serialID 
            		+ " could not be found. ";
         return feedString;
      }
   }
}