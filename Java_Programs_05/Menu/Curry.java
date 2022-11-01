public class Curry extends Menu {
   
   private String item;//menu item number
   private String size;//large,medium,small
   private String curry;
   
   public Curry(String itemNumber, String currySize) {
      super("Curry", itemNumber, currySize);
      this.curry = " "; 
   }
   
   public String getCurry() {
      return super.itemNumber();
   }

   public void curry(String curryType) {
      this.curry = curryType;
   }

   public String toString() {
      return super.toString() + ", " + this.curry; 
   }
}