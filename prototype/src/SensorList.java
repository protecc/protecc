import java.util.Arrays;

public class SensorList {
   private Sensor[] sensorList;
   
   public SensorList() {
      sensorList = new Sensor[0];
   }
   
   public void add(String serialID) {
      sensorList = Arrays.copyOf(sensorList, sensorList.length + 1);
      //sensorList[sensorList.length - 1] = new Sensor(serialID);
   }
   
   public void remove(String serialID) {
      int index = 0;
      
      for (Sensor sensor : sensorList) {
         if (sensor.getSerialID().equals(serialID)) {
            Sensor[] updatedList = new Sensor[sensorList.length-1];
            System.arraycopy(sensorList, 0, updatedList, 0, index);
            System.arraycopy(sensorList, index + 1, updatedList, index, sensorList.length - index - 1);
            sensorList = updatedList;
            
            return;
         }
         index += 1;
      }
      System.out.println("Error - sensor not found.");
   }
   
   //METHOD TO INSTANTIATE SENSOR OBJECTS
}