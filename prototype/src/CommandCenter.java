import java.util.Scanner;

public class CommandCenter {
   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("Command Center 0.0.1 | Protecc");
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
            case "911":
               //gets help
            case "lockdown":
               //initiates lockdown
            case "alarm on":
               //activates alarm
            case "alarm off":
               //deactivates alarm
            case "report":
               //access report controller
            case "sensor add":
               //add sensor
            case "sensor remove":
               //remove sensor
            case "system arm":
               //arm system
            case "system disarm":
               //disarm system
            case "settings":
               //view settings
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
   
   // requestFeed()
   
   //updateReport(contents)
   
   //lockdown()
   
   //viewReport()
   
   //sensorRequest(serialID,request)
   
   //changeSetting(name,value)
   
   //viewSettings()
}