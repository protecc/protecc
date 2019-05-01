import java.util.Scanner;

public class CommandCenter {

   public static ReportController reportController = new ReportController();
   public static SettingsController settingsController = new SettingsController();
   public static SensorList sensorList = new SensorList();
   
   public static void main(String[] args) {
      
      boolean status;
      
      Scanner input = new Scanner(System.in);

      Feed feed = new Feed();

      Locks locks = new Locks();
      Lock lock1 = new Lock();
      Lock lock2 = new Lock();
      Lock lock3 = new Lock();
      String serialID;
      // start off with three locks
      locks.addLock(lock1);
      locks.addLock(lock2);
      locks.addLock(lock3);
      // initialize settings with the placeholder settings
      settingsController.initializeSettings();

      System.out.println("Command Center 0.0.1 | Protecc");
      System.out.print("Please create a password: ");
      String userPIN = input.nextLine();
      ArmingController armingController = new ArmingController(userPIN);
      System.out.println("Type \"help\" for commands.");

      while (true) {
         System.out.print(">>> ");
         String command = input.nextLine();

         switch (command.toLowerCase()) {
            case "help":
               getHelp();
               break;
            case "feed":
               //accesses feed
               System.out.println("\nHere are the current sensors: ");
               Sensor[] currentSensors = sensorList.getList();
               for (Sensor sensor : currentSensors) {
                  System.out.print("ID: " + sensor.getSerialID() + " type: " +sensor.getType() + "\n");
               }
               System.out.print("\nEnter a serial ID for a sensor to see its feed: ");
               serialID = input.nextLine();
               requestFeed(serialID, feed, sensorList);
               break;
            case "911":
               System.out.println("Contacting emergency service...");
               System.out.println("Help is on the way.");
               break;
            case "lockdown":
               //initiates lockdown
               lockdown(locks, armingController);
               break;
            case "alarm on":
               //activates alarm
               armingController.changeAlarmStatus();
               break;
            case "alarm off":
               //deactivates alarm
               armingController.changeAlarmStatus();
               break;
            case "report":
               //access report controller
               updateReport(reportController);
               break;
            case "sensor add":
               System.out.print("Enter the serial ID of the sensor being added: ");
               serialID = input.nextLine();
               System.out.print("Please enter the type of sensor being added "
                  + "(Camera, Gas Detector, Smoke Detector, or Motion Sensor): ");
               String type = input.nextLine();
               sensorList.add(serialID, type);
               break;
            case "sensor remove":
               System.out.print("Enter the serial ID of the sensor being removed: ");
               serialID = input.nextLine();
               sensorList.remove(serialID);
               break;
            case "system arm":
               armingController.arm();
               break;
            case "system disarm":
               armingController.disarm();
               break;
            case "settings":
               //view settings menu
               settingsController.settingsMenu();
               break;
            case "exit":
               return;
            default:
               System.out.println("Invalid command. Type \"help\" for commands.");
         }
      }
   }
   
   public static void getHelp() {
      System.out.println("\nCommands: ");
      System.out.println("feed - Access feed controller commands.");
      System.out.println("911 - Contacts your local emergency services.");
      System.out.println("lockdown - Initiates the lockdown sequence.");
      System.out.println("report - Access report controller commands.");
      System.out.println("alarm on[off] - [de]activates the alarm.");
      System.out.println("sensor add[remove] - initiates a sensor request.");
      System.out.println("sysem arm[disarm] - [dis]arms the system.");
      System.out.println("settings - accesses the system settings.");
      System.out.println("exit - log off system.\n");
   }
   
   public static void requestFeed(String serialID, Feed feed, SensorList sensorList) {
      String feedString = feed.showFeed(serialID, sensorList);
      System.out.println(feedString);
   }

   public static void lockdown(Locks locks, ArmingController armingController) {
      armingController.lockEntries(locks);
   }

   public static void updateReport(ReportController reportController) {
      reportController.reportMenu();
   }

   public static Sensor sensorRequest(String serialID, String request) {
      for (Sensor sensor : sensorList.getList()) {
         if (sensor.getSerialID().equals(serialID)) {
            return sensor;  
         }
      }
      return null;
   }   

   public static void changeSetting(String name, int value) {
      settingsController.adjustSettings(name, value);
   }  

   public static void viewSettings() {
      settingsController.showSettings();
   }
}
