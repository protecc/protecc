/*
 * A simple structure for a lock.
 */
public class Lock {
   private boolean status;
   
   // Defaults to a locked state.
   public Lock() {
      status = false;
   }
   
   public boolean isLocked() {
      return status;
   }
   
   public void unlock() {
      status = false;
   }
   
   public void lock() {
      status = true;
   }
}