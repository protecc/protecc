import java.util.Scanner;

public class CommandCenter {
   public static void main(String[] args) {
      
      boolean status;
      
      Scanner input = new Scanner(System.in);

      SensorList sensorList = new SensorList();
      Sensor[] sensorArray = new Sensor[0];
      Feed feed = new Feed();
      ReportController reportController = new ReportController();
      SettingsController settingsController = new SettingsController();
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
               System.out.print("Enter a serial ID for a sensor to see its feed: ");
               serialID = input.nextLine();
               requestFeed(serialID, sensorArray, feed, sensorList);
               break;
            case "911":
               //gets help
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
               sensorArray = sensorList.add(serialID, type, sensorArray);
               break;
            case "sensor remove":
               System.out.print("Enter the serial ID of the sensor being removed: ");
               serialID = input.nextLine();
               sensorArray = sensorList.remove(serialID, sensorArray);
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
   
   public static void requestFeed(String serialID, Sensor[] sensorArray, Feed feed, SensorList sensorList) {
      String feedString = feed.showFeed(serialID, sensorArray, sensorList);
      System.out.println(feedString);
   }

   public static void lockdown(Locks locks, ArmingController armingController) {
      armingController.lockEntries(locks);
   }

   public static void updateReport(ReportController reportController) {
      reportController.reportMenu();
   }

   public static void viewReport() {
      reportController.showReport();
   }

   public static Sensor sensorRequest(String serialID, String request) {
      for (Sensor thisSensor : sensorArray) {
         if (thisSensor.getSerialID == serialID) {
            return thisSensor;  
         }
      }
   }   

   public static void changeSetting(String name, int value) {
      settingsController.adjustSetting(name, value);
   }  

   public static void viewSettings() {
      settingsController.showSettings();
   }
}
