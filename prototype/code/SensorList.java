import java.util.Arrays;

public class SensorList {
   private Sensor[] sensorList;
   
   public SensorList() {
      sensorList = new Sensor[0];
   }
   
   public void add(String serialID, String type) {
      sensorList = Arrays.copyOf(sensorList, sensorList.length + 1);
      if (type.toLowerCase().equals("camera")) {
         sensorList[sensorList.length - 1] = new Camera(serialID, type);
      }
      else if (type.toLowerCase().equals("gas detector")) {
         sensorList[sensorList.length - 1] = new GasDetector(serialID, type);
      }
      else if (type.toLowerCase().equals("smoke detector")) {
         sensorList[sensorList.length - 1] = new SmokeDetector(serialID, type);
      }
      else if (type.toLowerCase().equals("motion sensor")) {
         sensorList[sensorList.length - 1] = new MotionSensor(serialID, type);
      }
      else {
         System.out.println("Sensor " + type + " not supported. Please enter "
            + "either a Camera, Gas Detector, Smoke Detector, or Motion Sensor ");
      }
   }
   
   public void remove(String serialID) {
      int index = 0;
      
      for (Sensor sensor : sensorList) {
         if (sensor.serialID.equals(serialID)) {
            Sensor[] updatedList = new Sensor[sensorList.length-1];
            System.arraycopy(sensorList, 0, updatedList, 0, index);
            System.arraycopy(sensorList, index + 1, updatedList, index, sensorList.length - index - 1);
            System.out.println("Sensor removed");
            sensorList = updatedList;
            return;
         }
         index += 1;
      }
      System.out.println("Error - sensor not found.");
   }
   
   public Sensor getSensor(String serialID) {
      for (Sensor sensor : sensorList) {
         if (sensor.serialID.equals(serialID)) {
            return sensor;
         }
      }
      return null;
   }
   
   public Sensor[] getList() {
      return sensorList;
   }
}