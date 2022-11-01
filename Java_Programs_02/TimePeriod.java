public class TimePeriod{

   private Duration lowerBound;
   private Duration upperBound;
   
   public TimePeriod(Duration lowerBound, Duration upperBound)
   {
      this.lowerBound = lowerBound;
      this.upperBound = upperBound;
   }
   
   public Duration lowerBound()
   {
      return this.lowerBound; 
   }
   
   public Duration upperBound()
   {
      return this.upperBound;
   }
   
   public boolean includes(Duration duration)
   {
      if (((this.lowerBound().compareTo(duration) <= 0)) && (duration.compareTo(this.upperBound()) < 0))
      {
         return true;
      }  
      return false;
   }
   
   public boolean precedes(TimePeriod other)
   {
      if (this.upperBound().compareTo(other.lowerBound()) <= 0){
         return true;
      }
      return false;
   }
   
   public boolean adjacent(TimePeriod other)
   {
      if (((this.lowerBound().compareTo(other.upperBound()) == 0) || (this.upperBound().compareTo(other.lowerBound()) == 0))){
         return true;
      }
      return false;
   }
   
   public String toString()
   {
     return "[" + Duration.format(this.lowerBound(), TimeUnit.MINUTE) + " .. " + Duration.format(this.upperBound(), TimeUnit.MINUTE) + "]";
   }
}