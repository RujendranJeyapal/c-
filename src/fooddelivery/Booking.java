package fooddelivery;

import java.util.ArrayList;
import java.util.List;

public class Booking 
{
           
	      private int bookingId;
	      private DeliveryExecutive executive;
	      private List<Customer> customers=new ArrayList<>();
	      private String restaurant;
	      private String destinationPoint;	   
	      private String deliveryTime;
	      private double deliveryCharge;
	      private double allowance;
	      
	      
	      
	      
	      
	      
		  public Booking(int bookingId, DeliveryExecutive executive, Customer customers, String restaurant  ,String destinationPoint,
				String deliveryTime, double deliveryCharge, double allowance) 
		  {
			  
			this.bookingId = bookingId;
			this.executive = executive;
			this.customers.add(customers);
			this.restaurant=restaurant;
			this.destinationPoint = destinationPoint;
			this.deliveryTime = deliveryTime;
			this.deliveryCharge = deliveryCharge;
			this.allowance = allowance;
			
		  }
		  
		  
		  public void setDeliveryCharge(double deliveryCharge) 
		  {
			    this.deliveryCharge += deliveryCharge;
		  }
		  
		  
		  public void setCustomers(Customer customer)
		  {
			   this.customers.add(customer);
		  }

		  
		  public void setDeliveryTime(String deliveryTime) 
		  {
			    this.deliveryTime = deliveryTime;
		  }


		  public int getBookingId() 
		  {
			  return bookingId;
		  }
		  

		  public DeliveryExecutive getExecutive() 
		  {
			  return executive;
		  }
	
		  
		  public String getDestinationPoint() 
		  {
			   return destinationPoint;
		  }

		  
		  public String getDeliveryTime() 
		  {
			    return deliveryTime;
		  }
	
		  
		  public double getDeliveryCharge()
		  {
			    return deliveryCharge;
		  }
  
		  public double getAllowance() 
		  {
			    return allowance;
		  }
		  
	      public int getOrder()
	      {
	    	   return customers.size();
	      }
	      
	      public String getRestaurant()
	      {
	    	   return restaurant;
	      }


		  @Override
		  public String toString() 
		  {
			  
			   return bookingId + "\t\t" + executive.getExecutive()+ "\t\t" +restaurant
					+ "\t\t" + destinationPoint + "\t\t" + customers.size()+"\t\t"+customers.get( customers.size()-1 ).getTime() +"\t\t"
					+deliveryTime+"\t\t"+deliveryCharge ;
		  }
	      
	      
	      
	
}
