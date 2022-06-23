package flightticketbooking;

import java.util.Map;

public class Ticket 
{
     private String bookingID;
     private String flightNo;
     private String source;
     private String destination;
     private String flightClass;
     private boolean foodPreference;
     private Map<String,Passenger> passengers;
     private double totalAmount;
     
     
	public Ticket(String bookingID, String flightNo, String source, String destination, String flightClass,
			boolean foodPreference, Map<String, Passenger> passengers, double totalAmount)
	{
		this.bookingID = bookingID;
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.flightClass = flightClass;
		this.foodPreference = foodPreference;
		this.passengers = passengers;
		this.totalAmount = totalAmount;
	}


	public String getBookingID() 
	{
		return bookingID;
	}


	public String getFlightNo() 
	{
		return flightNo;
	}


	public String getSource()
	{
		return source;
	}


	public String getDestination() 
	{
		return destination;
	}


	public String getFlightClass() 
	{
		return flightClass;
	}


	public boolean isFoodPreference() 
	{
		return foodPreference;
	}


	public Map<String, Passenger> getPassengers() 
	{
		return passengers;
	}


	public double getTotalAmount() 
	{
		return totalAmount;
	}


	@Override
	public String toString() 
	{
		return "bookingID=" + bookingID + "\n flightNo=" + flightNo + "\n source=" + source + "\n destination="
				+ destination + "\n flightClass=" + flightClass + "\n foodPreference=" + foodPreference + "\n passengers="
				+ passengers + "\n totalAmount=" + totalAmount ;
	}
	
	
	
     
     
	   
     
     
     
     
	 
     
     
     
}
