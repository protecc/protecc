import java.util.Arrays;
/*
 * Locks class is a collection of Lock objects. It can lock the locks within it.
 */
public class Locks {

   private Lock[] lockList;
   
   public Locks() {
      lockList = new Lock[0];
   }
   
   public void addLock(Lock newLock) {
      lockList = Arrays.copyOf(lockList, lockList.length + 1);
      lockList[lockList.length - 1] = newLock;
   }

   public boolean lockEntry(Lock thisLock) {
      thisLock.lock();
      return thisLock.isLocked();
   }
   
   public Lock[] getLocks() {
      return lockList;
   }
   
}
