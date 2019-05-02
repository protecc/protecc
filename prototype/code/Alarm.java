/*
 * Standard alarm class. Can get and manipulate status.
 * If status is true, physical alarm would sound.
 */
public class Alarm {
   public boolean status;
   
   public Alarm() {
      status = false;
   }
   
   public boolean getStatus() {
      return status;
   }
   
   public void setStatus(boolean newStatus) {
      status = newStatus;
   }
}