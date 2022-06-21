package flightticketbooking;

import java.util.ArrayList;
import java.util.List;

public class Flight 
{
       private String flightNo;
       private String source;
       private String destination;
       private boolean economyFlight;
       private boolean businessFlight;
       private List<Seat> economySeats=new ArrayList<>();
       private List<Seat> businessSeats=new ArrayList<>();
      

	    public Flight(String flightNo, String source, String destination, boolean economyFlight, 
	    		boolean businessFlight,
			List<Seat> economySeats,List<Seat> businessSeats) 
	    {	
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.economyFlight = economyFlight;
		this.businessFlight = businessFlight;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
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



		public boolean isEconomyFlight() 
		{
			return economyFlight;
		}



		public boolean isBusinessFlight() 
		{
			return businessFlight;
		}



		public List<Seat> getEconomySeats() 
		{
			return economySeats;
		}
		
		public List<Seat> getBusinessSeats()
		{
			return businessSeats;
		}
	    
	    
}
