import java.util.Arrays;

/**
  * Base class for Great Internnational Food Court menu
  *
  * @author: Bonga Njamela
  * @version: 09/11/20
  */
public class Menu {
   
   private String item;
   private String type;
   private String size;
   private String base;
   private String cheese;
   private String garlic;
   private String curry;
   private String container;
   private String flavour;
   
   public Menu(String itemType, String itemNumber, String itemSize) {
      
      this.item = itemNumber;
      this.size = itemSize;
      this.type = itemType;
   }
   
   public String itemNumber() {
      return item;
   }
   
   public String getSize() {
      return size;
   }
   
   public String getType() {
      return type;
   }
   
   public void setType(String itemType) {
      this.type = itemType;
   }
  
   public String toString() {
      return this.type + ": " + item + ", " + size;
   }
}