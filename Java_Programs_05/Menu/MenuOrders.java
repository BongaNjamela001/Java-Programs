public class MenuOrders {
   
   private Menu[] orders;
   private int numOrders;
   
   public MenuOrders() {
      this.orders = new Menu[500];
   }
   
   public void addOrder(Menu menuItem) {
      
      for (int i = 0; i < 100; i++){
         if (this.orders[i] == (Menu) null){
            this.orders[i] = menuItem;
            this.numOrders++;
            break;
         }
         else
            continue;
      }
   }
   
   public boolean contains(String itemNumber){
      
      for (int i = 0; i < 100; i++){
         if (this.orders[i] != (Menu)null){
            if (((this.orders[i]).itemNumber()).equals(itemNumber))
               return true;
         }
         else
            break;
      }
      return false;   
   }
   
   /**
   The following method retrieves the order number with matching a itemNumber
   */
   public Menu retrieve(String itemNumber){
      
      Menu someOrder = new Menu(" ", "0", "random");
      
      for (int i = 0; i < 100; i++){
         
         if (this.orders[i] != (Menu) null){
            if ((this.orders[i]).itemNumber().equals(itemNumber))
               someOrder = this.orders[i];
            else
               continue;
         }
      }
      return someOrder;
   }
   
   /**
   Removes order item
   */
   public void delete(String itemNumber) {
      
      for (int i = 0; i < 100; i++){
         
             if (this.orders[i] != (Menu) null) {
                  if ((this.orders[i]).itemNumber().equals(itemNumber))
                  this.orders[i] = (Menu) null;
             }
             else
               continue;
     }
   }
   
   public Menu[] getOrders() {
      return this.orders;
   }
}