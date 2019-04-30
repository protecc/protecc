public class Feed {

   protected String serialID;

   public String showFeed(String inputSerialID, Sensor[] sensorArray, SensorList sensorList) {
   
      String feedString;
      Sensor sensor = sensorList.findSensor(inputSerialID, sensorArray);
   
      if (sensor != null)
      {
         if (sensor.getIssueDetected()) {
            feedString = "Showing feed for sensor with serial ID "
               + inputSerialID + ": There was an issue detected. ";
            return feedString;
         }
         else {
            feedString = "Showing feed for sensor with serial ID "
               + inputSerialID + ": There are no issues detected. ";
            return feedString;
         }
      }
      else {
         feedString = "Sensor with serial ID " + inputSerialID 
            		+ " could not be found. ";
         return feedString;
      }
   }
}