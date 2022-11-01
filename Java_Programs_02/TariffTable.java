public class TariffTable{
   
   private ParkingTariff tableTariff;
   private int row;
   private int totalRows;
   private int rowEntries;
   private ParkingTariff[] tariffs;
   private String tableEntryStr;
   private Money amountAccess;
   
   //TariffTable Constructor
   public TariffTable(int maxSize){
      this.totalRows = maxSize;
      this.row = 0;
      this.rowEntries = 0;
      this.tariffs = new ParkingTariff[maxSize];
      this.tableEntryStr = "";
   }
   
   /**Adds tariff if the 'period' is adjacent <*Using TimePeriod class adjacent() method*>
    * to or follows the period of the previous tariff.
    * If the abovementioned conditions are not met, then an IllegalArgumentException is thrown.
    */ 
   public void addTariff(TimePeriod period, Money tariff){
      ParkingTariff newTariff = new ParkingTariff(period, tariff);
      Duration max = period.upperBound(); 
      
      for (row = 0; row < this.totalRows; row++){
         if (row == 0){
            if (this.tariffs[row] == (ParkingTariff)null){
              this.tariffs[row] = newTariff;
              this.rowEntries++;
              break;
            }  
            else
               continue;    
         }
         else{
            if ((this.tariffs[row] == (ParkingTariff)null) && (this.tariffs[0] != (ParkingTariff)null)){
               if ((period.adjacent(this.tariffs[row-1].period())) && this.tariffs[row-1].period().precedes(period)){
                  this.tariffs[row] = newTariff;
                  this.rowEntries++;
                  break;
               }
               
               else if ((row == totalRows - 1) && ((period.adjacent(this.tariffs[row-1].period()) && (this.tariffs[row-1].period().precedes(period))))){
                  this.tariffs[row] = newTariff;
                  this.rowEntries++;
                  break;
               }
               
               else
                  throw new IllegalArgumentException("Tariff periods must be adjacent.");
            }
         }  
      }
   }
   
   /** Returns the cost of parking there for a certain duration.*/
   public Money getTariff(Duration lengthOfStay){
      
      for (row = 0; row < this.totalRows; row++){
         if (this.tariffs[row] != (ParkingTariff)null){   
            if (this.tariffs[row].cost(lengthOfStay) != (Money)null){
               this.amountAccess = this.tariffs[row].cost(lengthOfStay);
               break;
            }
            else
               continue;
         }
         else
            break;
      }
      return this.amountAccess;
   }
   
   /** Returns a string representation of the TableTariff of the form 
    * "<period_0>: <tariff_0>
    *  <period_1>: <tariff_1>
    *           .
    *           .
    *           .
    *  <period_n>: <tariff_n>"
    */ 
   public String toString(){
      
      String tableTariffStr = "";
      for (row = 0; row < this.rowEntries; row++){
         if (this.tariffs[row] != (ParkingTariff)null){
            if (row == this.rowEntries-1){
               tableTariffStr = this.tariffs[row].period().toString() + " : " + this.tariffs[row].tariff().toString();
            }
            else{
               tableTariffStr = this.tariffs[row].period().toString() + " : " + this.tariffs[row].tariff().toString() + "\n";
            }
            this.tableEntryStr += tableTariffStr;
         }   
      }
      return this.tableEntryStr;
   }
}