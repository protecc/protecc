import java.util.Arrays;

public class SensorList {
   private Sensor[] sensorList;
   
   public SensorList() {
      sensorList = new Sensor[0];
   }
   
   public Sensor[] add(String serialID, String type, Sensor[] sensorArray) {
      sensorArray = Arrays.copyOf(sensorArray, sensorArray.length + 1);
      if (type.toLowerCase().equals("camera")) {
         sensorArray[sensorArray.length - 1] = new Camera(serialID, type);
      }
      else if (type.toLowerCase().equals("gas detector")) {
         sensorArray[sensorArray.length - 1] = new GasDetector(serialID, type);
      }
      else if (type.toLowerCase().equals("smoke detector")) {
         sensorArray[sensorArray.length - 1] = new SmokeDetector(serialID, type);
      }
      else if (type.toLowerCase().equals("motion sensor")) {
         sensorArray[sensorArray.length - 1] = new MotionSensor(serialID, type);
      }
      else {
         System.out.println("Sensor " + type + " not supported. Please enter "
            + "either a Camera, Gas Detector, Smoke Detector, or Motion Sensor ");
      }
      return sensorArray;
   }
   
   public Sensor[] remove(String serialID, Sensor[] sensorArray) {
      int index = 0;
      
      for (Sensor sensor : sensorArray) {
         if (sensor.serialID.equals(serialID)) {
            Sensor[] updatedList = new Sensor[sensorArray.length-1];
            System.arraycopy(sensorArray, 0, updatedList, 0, index);
            System.arraycopy(sensorArray, index + 1, updatedList, index, sensorArray.length - index - 1);
            System.out.println("Sensor removed");
            return updatedList;
         }
         index += 1;
      }
      System.out.println("Error - sensor not found.");
      return sensorArray;
   }
   
   public Sensor findSensor(String serialID, Sensor[] sensorArray) {
      for (Sensor sensor : sensorArray) {
         if (sensor.serialID.equals(serialID)) {
            return sensor;
         }
      }
      return null;
   }
   //METHOD TO INSTANTIATE SENSOR OBJECTS
}