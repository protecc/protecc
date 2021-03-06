import java.util.Scanner;
/*
 * In control of communications with emergency serv
 */
public class EmergencyController {

   Scanner input = new Scanner(System.in);
  
   //contact info could be for police, ambulence, emt, etc.
   private String police = "911-1";
   private String fire = "911-2";
   private String emt = "911-3"; 
   private String emergencyNeed;
   
   public EmergencyController(String emergencyNeed) {
      this.emergencyNeed = emergencyNeed;
   }
   
   // flips the alarm status
   public void callHelp() {
      System.out.println("Enter emergency number: ");
      String emergencyNeed = input.nextLine();
      this.emergencyNeed = emergencyNeed;
      if (emergencyNeed.equals(police)) {
        System.out.println("Calling for police!");
      }
      else if (emergencyNeed.equals(fire)) {
        System.out.println("Calling for fire department!");
      }
      else if (emergencyNeed.equals(emt)) {
        System.out.println("Calling for emt!");
      }
      else {
        System.out.println("Invalid emergency number.");
      }
   }
   
   
   public String getEmergencyContactInfo() {
      int userChoice;
      System.out.println("Enter 1 for police, 2 for fire, 3 for emt.");
      userChoice = input.nextInt();
      
      switch(userChoice) {
      
        case 1:
        return police;
        
        case 2:
        return fire;
        
        case 3:
        return emt;
        
      }
      return police;
   }
   
   public void verifySafety() {
      System.out.println("Are you okay? Enter yes or no.");
      String userChoice = input.nextLine();
      if (userChoice.equals("no")) {
         System.out.println("Emergency Services have been notified.");
      }
   }
   
   //set alarm
   public boolean setAlarm() {
      Alarm alarm = new Alarm();
      alarm.setStatus(true);
      if (alarm.getStatus()) {
        System.out.println("Alarm activated.");
        return true;
      }
      else {
        System.out.println("Alarm not activated.");
        return false;
      }
   }
  
}
