package fooddelivery;

import java.util.HashMap;
import java.util.Map;

public class FoodDeliveryManagement 
{

	   private Map<Integer,Booking>  bookingHistory=new HashMap<>();
	   private Map< String , DeliveryExecutive > allDeliveryExecutives=new HashMap<>();
	   
	   
	   public void addBooking( Booking book   )
	   {
		     bookingHistory.put( book.getBookingId() , book );
	   }



	   public Map<Integer,Booking> getAllBookings() 
	   {
		     return bookingHistory;
	   }
	   
	   
	   public void addExecutives( DeliveryExecutive executive )
	   {
		     allDeliveryExecutives.put( executive.getExecutive() , executive );
	   }

	   public Map<String, DeliveryExecutive> getAllDeliveryExecutives() 
	   {
		     return allDeliveryExecutives;
	   }
	   
	   
}
