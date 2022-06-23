package flightticketbooking;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookingDriver 
{
        
	  private FileStorage callFile=new FileStorage();
	  
	  private FlightTicketManagement callCache=new FlightTicketManagement();
	  
	  private int bookingId=1;
	  
	  
	  public Seat getSeat(String seatNo)
	  {
		  return callCache.getSeats(seatNo);
	  }
	  
	  public void addTicket(Ticket ticket)
	  {
		  callCache.bookTicket(ticket);
	  }
	  
	  public Ticket getTicket(String ticketId)
	  {
		  return callCache.getTicket(ticketId);
	  }
	  
	  public String availableSeatForA112()
	  {
		  return callFile.readFileA112();
	  }
	  
	  
	  public String availableSeatForA113()
	  {
		  return callFile.readFileA113();
	  }
	  
	  
	  public String availableSeatForA114()
	  {
		  return callFile.readFileA114();
	  }
	  
	  public String generateBookId()
	  {
		  return "Ticket"+bookingId;
	  }
	  
	  public double bookTicket(Map<String,Passenger> passengers,boolean mealPreference,Flight flight,String flightClass)
	  {
		  
		  
		  double totalAmount=0;
		  
		  for( String seatNo:passengers.keySet() )
		  {
			  
			  Seat seat=getSeat(seatNo );
			  
			
			  
			  Passenger passenger=passengers.get( seatNo );
			  double amount=0;
			  
			  if( flightClass.equals("Business" ) )
			  {
				  amount+=flight.getBusinessRate();
				  
				  Seat businessSeat=flight.getBusinessSeat( seatNo );
				
				   businessSeat.setStatus("booked");
				   
				   callFile.updateFile(flight);
				   
				   callCache.storeFlight(flight);
				  
				  flight.setBusinessRate( amount+flight.getSugeRateForBusiness()   );
				  
				  callCache.addSeat(businessSeat);
				  
				  
				  
			  }
			  
			  else
			  { 
				  amount+=flight.getEconomyRate();  
				  
				  Seat economySeat=flight.getEconomySeat( seatNo );
					
				   economySeat.setStatus("booked");
				   
				   callFile.updateFile(flight);
				   
				   callCache.storeFlight(flight);
				   
				  flight.setEconomyRate( amount+flight.getSugeRateForEconomy()   );
				  
				  callCache.addSeat(economySeat);
			  }
			  
			  if( mealPreference )
			  {
				  amount+=200;
			  }
			  
			
			  String seatType=seat.getSeatType();
			  
			  if( seatType.equals("W") || seatType.equals("A") )
			  {
				  amount+=100;
			  }
			  
			  
			  
			  passenger.setAmount(amount);
			  
			  totalAmount+=amount;
		  }
		  
		  return totalAmount;
		 
	  }
	  
	  
	  public void cancelTicket(String ticketId,String seatNo)
	  {
		  
		  
		    Ticket ticket=getTicket( ticketId );
		    
		    Map<String,Passenger> bookedPassengers=ticket.getPassengers();
		    
	       
	         
		     bookedPassengers.remove(seatNo);
		     
		     callCache.bookTicket(ticket);
		    	   
		     String flightName=ticket.getFlightNo();
		     
		     Flight flight=getFlight(flightName);
		     
		     String flightClass=ticket.getFlightClass();
		     
		     if( flightClass.equals("Business") )
		     {
		    	 Seat seat=flight.getBusinessSeat(seatNo);
		    	 
		    	 seat.setStatus("vaccant");
		    	 
		    	 callFile.updateFile(flight);
		    	 
		    	 callCache.storeFlight(flight);
		    	 
		    	 callCache.addSeat(seat);
		     }
		     
		     else
		     {
		    	 Seat seat=flight.getEconomySeat(seatNo);
		    	 
		    	 seat.setStatus("vaccant");
		    	 
		    	 callFile.updateFile(flight);
		    	 
		    	 callCache.storeFlight(flight);
		    	 
		    	 callCache.addSeat(seat);
		     }
		    	   
		 
		    
	  }
	  
	  
	  public String[] getFlightNames()
	  {
		  String files[]= callFile.getFlightNames();
		  
		  int i=0;
		  
		  for( String temp:files )
		  {
			  int index=temp.indexOf('.');
			  
			  files[i]=temp.substring(0,index);
			  
			  i++;
		  }
		  
		  return files;
	  }
	  
	  public Flight getFlight(String flightNo)
	  {
		  return callCache.getFlight(flightNo);
	  }
	  
	  public List<String> getBusinessClassAloneFlights()
	  {
		  return callCache.getBusinessClassAloneFlights();
	  }
	
	  
	  public List<String> getFlightNoFromSrcDestin(String source,String destination)
	  {		  
		  return callCache.getFlightsFromSrcDisti(source, destination);
	  }
	  
	  
	  
	  
	  public boolean isFlightHere(String flightNo)
	  {
		  String flights[]=getFlightNames();
		  
		  int i=0;
		  
		  for( String temp:flights )
		  {
			  String temp1=temp.substring(temp.indexOf('-')+1);
			  flights[i]=temp1.substring( 0 , temp1.indexOf('-'));
			  i++;
		  }
		  
		 
		  for( String temp:flights )
		  {
			  if( temp.equals(flightNo) )
			  {
				  return true;
			  }
		  }
		  
		  return false;
		  
	  }
	  
	  
	  private LinkedHashMap<String,Seat> getBusinessClass()
      {
          LinkedHashMap<String,Seat> seatList=new LinkedHashMap<>();
      	
      	 String types;
      	
      	     for( int i=1;i<=12;i++ )
      	     {
      	    	    for( char j='A';j<='G';j++ )
      	    	    {
      	    	    	     if( j=='A' || j=='G' )
      	    	    	     {
      	    	    	    	 types="W";
      	    	    	     }
      	    	    	     
      	    	    	     else if( j=='D' )
      	    	    	     {
      	    	    	    	 types="M";
      	    	    	     }
      	    	    	     
      	    	    	     else
      	    	    	     {
      	    	    	    	 types="A";
      	    	    	     }
      	    	    	
      	    	             seatList.put( i+"_"+j , new Seat(i+"_"+j,types,"vaccant") );	  
      	    	    }
      	     }
      	     
      	     return seatList;
      }
      
      private LinkedHashMap<String,Seat> getEconomicClass()
      {
      	 LinkedHashMap<String,Seat> seatList=new LinkedHashMap<>();
      	 
      	 String types;
      	 
      	   for( int i=1;i<=20;i++ )
      	   {
      		   for( char j='A';j<='K';j++ )
      		   {
      			       if( j=='A' || j=='K' )
      			       {
      			    	   types="W";
      			       }
      			       
      			       else if( j=='C' || j=='D' || j=='G' || j=='H' )
      			       {
      			    	   types="A";
      			       }
      			       
      			       else
      			       {
      			    	   types="M";
      			       }
      			       
      			       seatList.put(i+"_"+j , new Seat(i+"_"+j,types,"vaccant") );
      			    
      		   }
      	   }
      	   
      	   return seatList;
      }
      
      public BookingDriver()
      {
    	  
    	  LinkedHashMap<String,Seat> economicClassSeats=getEconomicClass();
     	 LinkedHashMap<String,Seat> businessClassSeats=getBusinessClass();
     	 
     	 Flight flightA112=new Flight( "A112","CHENNAI","MUMBAI",true,true,
     			 1000,2000,100,200,economicClassSeats,businessClassSeats );
  	    
  	     callFile.updateFileA112(flightA112);
  	     
  	     Flight flightA113=new Flight( "A113","CHENNAI","KOLKATHA",true,true,
  	    		 1000,2000,100,200,economicClassSeats,businessClassSeats);
  	     
  	     callFile.updateFileA113(flightA113);
  	     
  	     Flight flightA114=new Flight( "A114","CHENNAI","DELHI",true,false,
 	    		 1000,2000,100,200,null,businessClassSeats);
  	     
  	     callFile.updateFileA114(flightA114);
  	     
  	     callCache.setAllSeats(businessClassSeats);
  	     
  	     callCache.setAllSeats(economicClassSeats);
  	     
  	     callCache.storeFlight(flightA112);
  	     
  	     callCache.storeFlight(flightA113);
  	   
  	     callCache.storeFlight(flightA114);
  	     
  	     callCache.setFlightBasedSrcDist(flightA112);
  	     
  	     callCache.setFlightBasedSrcDist(flightA113);
  	   
  	     callCache.setFlightBasedSrcDist(flightA114);
  	     
  	     callCache.setBusinessClassAloneFlights(flightA114);
  	     
      }

	public boolean isSeatHere(String seatNumber, Flight flight, String flightClass)
	{
		if( flightClass.equals("Business") )
		{
			Seat seat=flight.getBusinessSeat(seatNumber);
			
			if(  seat==null ||  seat.getStatus().equals("booked") )
			{
				return false;
			}
		}
		
		if( flightClass.equals("Economic") )
		{
			Seat seat=flight.getEconomySeat(seatNumber);
			
			if(  seat==null ||  seat.getStatus().equals("booked") )
			{
				return false;
			}
		}
		
		return true;
	}

	
	
	
	   
    public  void printSeatsHaveMeals(String flightNo)
    {
  	    callCache.printSeatsHaveMeals(flightNo);
    }

	public boolean seatNumberCheck(Ticket ticket, String seatNo) 
	{
		Map<String,Passenger> passengers=ticket.getPassengers();
		
		for( String key:passengers.keySet() )
		{
			if( key.equals( seatNo ) )
			{
				return true;
			}
		}
		
		return false;
	}
	
	  
	
}
