package fooddelivery;

public class DeliveryExecutive 
{
         private String executive;
         private double allowance;
         private double deliveryCharges;
         private String freeTime;
         
		 public String getExecutive()
		 {
			  return executive;
		 }
		 
		 public void setExecutive( String executive ) 
		 {
			  this.executive = executive;
		 }

		 public double getAlloances() 
		 {
			  return allowance;
		 }

		 public void setAlloances(double allowance) 
		 {
			  this.allowance += allowance;
		 }
		 
		 public double getDeliveryCharges() 
		 {
			  return deliveryCharges;
		 }

		 public void setDeliveryCharges(double deliveryCharges)
		 {
			  this.deliveryCharges += deliveryCharges;
		 }


		 public String getFreeTime()
		 {
			  return freeTime;
		 }

		 public void setFreeTime(String freeTime) 
		 {
		 	  this.freeTime = freeTime;
		 }

		@Override
		 public String toString() 
		 {
			  return  executive +"\t\t"+ allowance + "\t\t"+ deliveryCharges +"\t\t"+(allowance+deliveryCharges) ;
		 }
         
         
         
         
         
}
