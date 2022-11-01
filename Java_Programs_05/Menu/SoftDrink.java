public class SoftDrink extends Menu {
   
   private String item;//menu item number
   private String size;//large,medium,small
   private String flavour;
   private String container;
   
   public SoftDrink(String itemNumber, String bottleSize) {
      super("Soft Drink", itemNumber, bottleSize);
      this.item = itemNumber;
      this.size = bottleSize;
      this.flavour = " ";
      this.container = " ";
   }
   
   public String getDrink() {
      return super.itemNumber();
   }

   public void container(String containerType) {
      this.container = containerType;
   }
   
   public void flavour(String userFlavour) {
      this.flavour = userFlavour;
   }
   
   public String toString() {
      return super.toString() + ", " + this.flavour + ", " + this.container; 
   }
}