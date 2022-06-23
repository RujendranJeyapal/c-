package flightticketbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FlightAccess 
{

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
	    
		BookingDriver callDriver=new BookingDriver();
		
		boolean condition=true;
	
	       while( condition )
	       {    
		
		        System.out.println("Press 1->List Flight Details\n"
				          + "Press 2->Handle Booking\n"
				          + "Press 3->Handle Cancellation\n"
				          + "Press 4->Print all available seats for each flight\n"
				          + "Press 5->Print Seat Number for which meal is ordered for each flight\n"
				          + "Press 6->Print individual and flight summary for all the bookings");
		
	        	int option=0;
		
	         	try
		        {
		             option=input.nextInt();
		        }
		        catch(InputMismatchException ex)
		        {
			         System.out.println("Enter Number Only");
		        }
		
		        input.nextLine();
		
		        switch(option)
		        {
		        
		               case 1:
		            	   
		    	               String flights[]=callDriver.getFlightNames();
		    	               
		    	               System.out.println("Total Number Of Flights :"+flights.length);
		            	       
		    	               System.out.println("Name Of the Flights :"+Arrays.toString( flights ) );
		    	   
		    	               break;
		    	      
		    	      
		    	      
		               case 2:
		    	   
		            	     try
		            	     {
		            	       
		            	       System.out.println("Enter Source");
		            	       String source=input.nextLine();
		            	       
		            	       System.out.println("Enter Destination");
		            	       String destination=input.nextLine();
		            	       
		            	       List<String> flightLists=callDriver.getFlightNoFromSrcDestin(source.toUpperCase(), destination.toUpperCase());
		            	       
		            	       if( flightLists==null )
		            	       {
		            	    	   System.out.println("No flights");
		            	       }
		            	       
		            	       else
		            	       {
		            	    	    System.out.println("Flights of your source and destinations are:");
		            	    	    System.out.println(flightLists);
		            	    	    
		            	    	    System.out.println("Businees Class Alone Flights are");
		            	    	    List<String> businessClassAloneFlights=callDriver.getBusinessClassAloneFlights();
		            	    	    System.out.println( businessClassAloneFlights );
		            	       
		            	       
		            	            System.out.println("Choose Flight Number");
		            	            String flightNumber=input.nextLine();
		            	            
		            	            System.out.println("Do you want to meal\nPress 1-->yes\nPress 2-->No");
           	            	        int choice=input.nextInt();
           	            	     
           	            	        boolean foodPreference=false;
           	            	        
           	            	        while( true )
           	            	        {
           	            	        if( choice==1 )
           	            	        {
           	            	    	     foodPreference=true;
           	            	    	     break;
           	            	        }
           	            	     
           	            	        else if( choice==0 )
           	            	        {
           	            	    	     foodPreference=false;
           	            	    	     break;
           	            	        }
           	            	        
           	            	        else
           	            	        {
           	            	        	System.out.println("Enter Correct Number");
           	            	        }
           	            	        
           	            	        }
           	            	        
           	            	        Flight flight=callDriver.getFlight(flightNumber);
           	            	     String flightClass="Business";
           	            	     
           	            	     if(! businessClassAloneFlights.contains(flightNumber) ) 
           	            	     {	 
           	            	        while( true )
           	            	        {
           	            	        System.out.println( "Which class you want \nPress 1-->Economic\nPress 2-->Business" );
           	            	        int classType=input.nextInt();
           	            	        input.nextLine();
           	            	        
           	            	       
           	            	        if( classType==2 )
           	            	        {   
           	            	        	   flightClass="Business";
           	            	               System.out.println( flight.getBusinessSeats() );
           	            	               break;
           	            	        }
           	            	        
           	            	        else if( classType==1 )
           	            	        {
           	            	        	flightClass="Economy";
           	            	        	System.out.println( flight.getEconomySeats() );
           	            	        	break;
           	            	        }
           	            	        
           	            	        else
           	            	        {
           	            	        	System.out.println("Choose correct Number");
           	            	        }
           	            	        
           	            	        
           	            	        }
           	            	        
		            	            	   
           	            	     }  	  
		            	            	System.out.println("Howmany Tickets you want");     
		            	            	int count=input.nextInt();
		            	            	input.nextLine();
		            	            	
		            	            	Map<String,Passenger> passengers=new HashMap<>();
		            	            	
		            	            	for( int i=0;i<count;i++ )
		            	            	{
		            	            		System.out.println("Enter Name");
		            	            		String name=input.nextLine();
		            	            		
		            	            		System.out.println("Enter Address");
		            	            		String address=input.nextLine();
		            	            		
		            	            		System.out.println("Choose the Sheet Number");
		            	            		String seatNumber=input.nextLine();
		            	            		
		            	            		if( callDriver.isSeatHere(seatNumber,flight,flightClass) )
		            	            		{
		            	            		 Passenger passenger=new Passenger();
		            	            	     passenger.setName(name);
		            	            	     passenger.setAddress(address);
		            	            	     
		            	            	     passenger.setSeat( seatNumber ); 
		            	            	     
		            	            	     passengers.put(seatNumber,passenger);
		            	            		}
		            	            		else
		            	            		{
		            	            			System.out.println("This Seat is already filled or This seat is not here. so Enter correct Seat Number");
		            	            		}
		            	            		
		            	            	}
		            	            	     
		            	            	double ticketAmount=callDriver.bookTicket(passengers, foodPreference, flight,flightClass);     
		            	            	  
		            	            	while(true )
		            	            	{
		            	            	     System.out.println("Pay the amount "+ticketAmount);
		            	            	     double pay=input.nextDouble();
		            	            	     
		            	            	     if( pay==ticketAmount )
		            	            	     {
		            	            	    	 Ticket ticket=new Ticket( callDriver.generateBookId(),flightNumber,source,destination,
		            	            	    			 flightClass,
		            	            	    			 foodPreference,passengers,ticketAmount);
		            	            	    	 callDriver.addTicket(ticket);
		            	            	    	 
		            	            	    	 System.out.println("Take your Ticket");
		            	            	    	 System.out.println(ticket);
		            	            	    	 
		            	            	    	 break;
		            	            	     }
		            	            	     else
		            	            	     {
		            	            	    	 System.out.println("Pay the correct Amount");
		            	            	     }
		            	            	     
		            	            	}   
		            	            	     
		            	              }
		            	              
		            	              
		            	     } 
		            	      
		            	     catch( InputMismatchException ex )
		            	     {
		            	    	 System.out.println("Enter Number Only");
		            	     }
		            	              
		            	       
		            	       
		    	   
		    	               break;
		    	               
		    	               
		               case 3:
				    	       System.out.println("Enter your BookingID");
				    	       String bookingId=input.nextLine();
				    	       
				    	       Ticket ticket=callDriver.getTicket(bookingId);
				    	       
				    	       Map<String,Passenger> passengers=ticket.getPassengers();
				    	       
		            	       System.out.println("Press-->1-->All cancel\nPress 2-->Individual ");
		            	       
		            	       int chose=input.nextInt();
		            	       
		            	       double amount=ticket.getTotalAmount();
		            	       
		            	         while(true)
		            	         {
		            	    	       if( chose==1 )
		            	    	       {
		            	    	    	   
		            	    	    	  for( String seatNo:passengers.keySet() )
		            	    	    	  {
		            	    	    		    callDriver.cancelTicket(bookingId, seatNo );
		            	    	    		    amount-=200;
		            	    	    	  }
		            	    	    	   
		            	    	    	   break;
		            	    	       }
		            	    	       else if( chose==2 )
		            	    	       {
		            	    	    	   System.out.println("Howmany seats to you cancel");
		            	    	    	   int count=input.nextInt();
		            	    	    	   
		            	    	    	   if( count>passengers.size() )
		            	    	    	   {
		            	    	    		   System.out.println("Too long");
		            	    	    	   }
		            	    	    	   else
		            	    	    	   {
		            	    	    		   
		            	    	    		   for( int i=0;i<count;i++ )
		            	    	    		   {
		            	    	    			   System.out.println("Enter your Seat No");
		            	    	    			   String seatNo=input.nextLine();
		            	    	    			   
		            	    	    			   if( callDriver.seatNumberCheck(ticket,seatNo) )
		            	    	    			   {   
		            	    	    			       callDriver.cancelTicket(bookingId, seatNo);
		            	    	    			       amount-=200;
		            	    	    			   }
		            	    	    			   
		            	    	    			   else
		            	    	    			   {
		            	    	    				   System.out.println("Seat Number is wrong");
		            	    	    			   }
		            	    	    		   }
		            	    	    		      
		            	    	    	   }
		            	    	    	   
		            	    	    	   
		            	    	    	   break;
		            	    	       }
		            	    	       else
		            	    	       {
		            	    	    	   System.out.println("Enter the correct Number");
		            	    	       }
		            	         }
				    	       
		            	         System.out.println("Cancellation Successfully\nTake the Refund Amount "+amount); 
				    	   
	    	                   break;
	    	      
	    	      
	    	      
	                   case 4:
	    	   
	                	      System.out.println("Flight-A112-Chennai-Mumbai");
	                	      
	                	      System.out.println(callDriver.availableSeatForA112());
	                	      
                              System.out.println("Flight-A112-Chennai-Kolkatha");
	                	      
	                	      System.out.println(callDriver.availableSeatForA113());
	                	      
                              System.out.println("Flight-A112-Chennai-Delhi");
	                	      
	                	      System.out.println(callDriver.availableSeatForA114());
	                	      
	    	   
	    	                  break; 
	    	               
	    	               
	    	               
                       case 5:
				    	   
				    	      System.out.println("Meals for FlightA112 is:");
				    	      
				    	      callDriver.printSeatsHaveMeals("A112");
				    	      
                              System.out.println("Meals for FlightA113 is:");
				    	      
				    	      callDriver.printSeatsHaveMeals("A113");
				    	      
				    	      
                              System.out.println("Meals for FlightA114 is:");
				    	      
				    	      callDriver.printSeatsHaveMeals("A114");
				    	   
	    	                  break;
	    	      
	    	      
	    	      
	                   case 6:
	    	        
	                	      System.out.println("Enter the Booking Id");
	                	      String id=input.nextLine();
	                	      
	                	      System.out.println( callDriver.getTicket(id) );
	    	   
	    	                  break;    
	    	                  
	    	           default:
	    	        	      condition=false;
	    	        	      break;
		    	      
		    	      
	       
		}
		        
	  }	        
		
	}

}
