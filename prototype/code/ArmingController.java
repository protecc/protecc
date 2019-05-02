import java.util.Scanner;
/*
 * In control of arming the system. Alarms, locks, etc.
 */
public class ArmingController {

   Scanner input = new Scanner(System.in);

   private Alarm houseAlarm;
   private String pin;
   
   public ArmingController(String userPIN) {
      houseAlarm = new Alarm();
      pin = userPIN;
   }
   
   // flips the alarm status
   public void changeAlarmStatus() {
      boolean authorized = requestPIN();
      if (!authorized) {
         System.out.println("Incorrect PIN.");
         return;
      }
      houseAlarm.setStatus(!houseAlarm.getStatus());
   }
   
   // returns true if all of the locks in the locks list are locked.
   public boolean returnResult(Locks lockList) {
      for (Lock lock : lockList.getLocks()) {
         if (!lock.isLocked()) {
            return false;
         }
      }
      return true;
   }
   
   // locks each lock in the locks list. Checks for a successful lockdown.
   public void lockEntries(Locks lockList) {
      System.out.println("Locking entries...");
      for (Lock lock : lockList.getLocks()) {
         lockList.lockEntry(lock);
      }
      System.out.println("Complete...");
      if (returnResult(lockList)) {
         System.out.println("All entries successfully locked.");
      } else {
         System.out.println("Lockdown failed.");
      }
   }
   // arms the system
   public void arm() {
      System.out.println("System armed.");
   }
   
   // disarms the system
   public void disarm() {
      boolean authorized = requestPIN();
      if (!authorized) {
         System.out.println("Invalid PIN.");
         return;
      }
      System.out.println("System disarmed.");
   }
   
   // returns whether or not the user correctly enters the pin.
   public boolean requestPIN() {
      System.out.print("\nPlease enter your PIN: ");
      String inputPIN = input.nextLine();
      if (inputPIN.equals(pin)) {
         return true;
      }
      else {
         return false;
      }
   }
}