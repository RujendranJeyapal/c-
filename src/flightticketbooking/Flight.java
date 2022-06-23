package flightticketbooking;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Flight 
{
       private String flightNo;
       private String source;
       private String destination;
       private boolean economyFlight;
       private boolean businessFlight;    
       private double economyRate;
       private double businessRate;
       private double sugeRateForEconomy;
       private double sugeRateForBusiness;
       private LinkedHashMap<String,Seat> economySeats=new LinkedHashMap<>();
       private LinkedHashMap<String,Seat> businessSeats=new LinkedHashMap<>();
       
       
	    public Flight(String flightNo, String source, String destination, boolean economyFlight, boolean businessFlight,
			double economyRate, double businessRate, double sugeRateForEconomy, double sugeRateForBusiness,
			LinkedHashMap<String, Seat> economySeats, LinkedHashMap<String, Seat> businessSeats) 
	    {
		
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.economyFlight = economyFlight;
		this.businessFlight = businessFlight;
		this.economyRate = economyRate;
		this.businessRate = businessRate;
		this.sugeRateForEconomy = sugeRateForEconomy;
		this.sugeRateForBusiness = sugeRateForBusiness;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
		
	    }
	    
	    
	    


		public void setEconomyRate(double economyRate) 
		{
			this.economyRate = economyRate;
		}





		public void setBusinessRate(double businessRate) 
		{
			this.businessRate = businessRate;
		}





		public void setEconomySeats(LinkedHashMap<String, Seat> economySeats) 
		{
			this.economySeats = economySeats;
		}





		public void setBusinessSeats(LinkedHashMap<String, Seat> businessSeats) 
		{
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


		public double getEconomyRate() 
		{			
			return economyRate;
		}


		public double getBusinessRate() 
		{
			return businessRate;
		}


		public double getSugeRateForEconomy() 
		{
			return sugeRateForEconomy;
		}


		public double getSugeRateForBusiness() 
		{
			return sugeRateForBusiness;
		}


		public LinkedHashMap<String, Seat> getEconomySeats() 
		{
			return economySeats;
		}


		public LinkedHashMap<String, Seat> getBusinessSeats() 
		{
			return businessSeats;
		}
       
	    
       public Seat getEconomySeat( String seatNo )
       {
    	   return economySeats.get(seatNo);
       }
       
       public Seat getBusinessSeat( String seatNo )
       {
    	   return businessSeats.get(seatNo);
       }
	    
	    
	    
	   


		
	    
}
