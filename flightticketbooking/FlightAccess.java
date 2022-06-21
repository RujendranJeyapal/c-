package flightticketbooking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightAccess 
{

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		FileStorage storage=new FileStorage();
		
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
		    	   
		    	   
		    	   
		    	               break;
		    	      
		    	      
		    	      
		               case 2:
		    	   
		    	   
		    	               break;
		    	               
		    	               
		               case 3:
				    	   
				    	   
				    	   
	    	                   break;
	    	      
	    	      
	    	      
	                   case 4:
	    	   
	    	   
	    	                  break; 
	    	               
	    	               
	    	               
                       case 5:
				    	   
				    	   
				    	   
	    	                  break;
	    	      
	    	      
	    	      
	                   case 6:
	    	   
	    	   
	    	                  break;    
		    	      
		    	      
		        
		}
		
	}

}
