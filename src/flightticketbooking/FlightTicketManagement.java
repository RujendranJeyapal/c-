package flightticketbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightTicketManagement 
{
	   private HashMap<String,Seat> allSeats=new HashMap<>();
	
       private Map<String,Ticket> bookedTickets=new HashMap<>();
       
       private Map<String,Flight> allFlights=new HashMap<>();
       
       private Map< String,Map< String,List<String> > > flightsBasedSrcDistin=new HashMap<>();
       
       private List<String>  businessClassAloneFlights=new ArrayList<>();
        
       
      public  void printSeatsHaveMeals(String flightNo)
      {
    	  if( bookedTickets!=null )
    	  {
    	     for( String id:bookedTickets.keySet() )
    	     {
    	    	 Ticket ticket=bookedTickets.get(id);
    	    	 
    	    	if( ticket.isFoodPreference() && ticket.getFlightNo().equals(flightNo) )
    	    	{
                          System.out.println( "Class "+ticket.getFlightClass()+" :" +ticket.getPassengers().keySet() ); 	    		
    	    	}
    	    	
    	    	else
    	    	{
    	    		System.out.println("No meals");
    	    	}
    	    	 
    	     }
    	  }   
    	  else
    	  {
    		    System.out.println("Tickets are not booked in this Flight");
    	  }
    	  
      }
       






	public void addSeat(Seat seat)
      {
    	    allSeats.put(seat.getSeatNo(), seat);
      }
       
       public void setAllSeats(HashMap<String, Seat> allSeats) 
       {
		     this.allSeats = allSeats;
	   }



	   public Seat getSeats(String seatNo)
       {
    	     return allSeats.get(seatNo);
       }
       
       
       
       public void bookTicket(Ticket ticket)
       {
    	      bookedTickets.put( ticket.getBookingID() , ticket );
       }
       
       public Ticket getTicket(String ticketId)
       {
    	     return bookedTickets.get(ticketId);
       }
       
       public void storeFlight(Flight flight)
       {
    	     allFlights.put( flight.getFlightNo() , flight );
       }
       
       public Flight getFlight( String flightNo )
       {
    	     return allFlights.get(flightNo);
       }
       
       public void setFlightBasedSrcDist(Flight flight)
       {
    	     Map<String,List<String> > distintBased=flightsBasedSrcDistin.get( flight.getSource() );
    	   
    	   
    	     if(  distintBased==null )
    	     {
    		      distintBased=new HashMap<>();
    		      flightsBasedSrcDistin.put( flight.getSource() , distintBased );
    	     }
    	   
    	        List<String> flightList=distintBased.get(flight.getDestination());
    	        
    	     if( flightList==null )
    	     {
    	    	    flightList=new ArrayList<>();
    	    	    distintBased.put( flight.getDestination() , flightList );
    	     }
    	     
    	          flightList.add( flight.getFlightNo() );
    	   
       }
       
       public void setBusinessClassAloneFlights(Flight flight)
       {
    	   if( flight.isBusinessFlight() && !flight.isEconomyFlight() )
    	   {	   
    	              businessClassAloneFlights.add( flight.getFlightNo() );   	              
    	   }
       }
       
       public List<String> getBusinessClassAloneFlights()
       {
    	      return businessClassAloneFlights;
       }
       
       
       public List<String> getFlightsFromSrcDisti(String source,String destination)
       {
    	   Map<String, List<String>> destinBased=flightsBasedSrcDistin.get(source);
    	   
    	   if( destinBased==null )
    	   {
    		   return null;
    	   }
    	   
    	   return destinBased.get(destination);
       }
       
       
       
       
       
       
}
