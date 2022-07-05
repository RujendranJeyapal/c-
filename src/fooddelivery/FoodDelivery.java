package fooddelivery;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FoodDelivery 
{
	
	 
	   
	   

	   public static void main( String[] args )
	   {
		   
		  Scanner input=new Scanner( System.in );
		   
		  FoodDeliveryDrive callDrive=new FoodDeliveryDrive();
		  
		  
		  
		  int count=0;
		   
		  while( true )
		  {
		      try
              {
		    	  System.out.println("Howmany executives you want");
                   count=input.nextInt();
           
                   break;
              }
              catch( InputMismatchException ex )
              {
	               System.out.println("Enter Number Only");
	               input.nextLine();
              }
		  
		  } 
		      
		  callDrive.setExecutive(count);
		   
		  boolean condition=true;
		  
		  while( condition )
		  {
		       System.out.println("Press 1-->Booking\nPress 2-->Delivery History\nPress 3-->Executives Total Earning\n Press others -->exit");
		   
		          int option=0;
		   
		          try
		          {
		                option=input.nextInt();
		                input.nextLine();
		          }
		          catch( InputMismatchException ex )
		          {
			            System.out.println("Enter Number Only");
		          }
		          
		          
		   
		      switch( option )
		      {
		   
		           case 1:
		    	 
		    	            System.out.println("Enter the Customer ID");
		    	            String cusID=input.nextLine();
		    	  
		    	            System.out.println("Choose the Restaurant"); 
		    	            String restaurant=chooseLocation( input );
		    	    	
		    	            System.out.println("Enter your destination point");
		    	            String destination=chooseLocation( input );	
		    	     
		    	            String time="";
		    	     
		    	            while( true )
		    	            {	 
		    	    	 
		    	    	          try
		    	    	          {
		    	                           System.out.println("Enter time\nTime Format is: hh:mm ");
		    	          
		    	                           time=input.nextLine();
		    	          
		    	                           if( callDrive.isTimeFormat( time )  )
		    	                           {
		    	            	                String meredian=getMeredian( input );
		    	            	   
		    	            	                time+=" "+meredian;
		    	            	    
		    	        	                    break;
		    	                           }
		    	               
		    	    	          }
		    	    	          catch( CustomException ex )
		    	    	          {
		    	    		                System.out.println( ex.getMessage() );
		    	    	          }
		    	               
		    	            }
		    	     
		    	     
		    	             Customer customer=new Customer( cusID,time );
		    	             
		    	             try
		    	             {
		    	                  String executive= callDrive.book( customer , destination , restaurant);
		    	                  
		    	    	          System.out.println("Alloted Delivery Executine "+executive);
		    	                  
		    	             }
		    	             catch( CustomException ex )
	    	    	         {
	    	    		                System.out.println( ex.getMessage() );
	    	    	         }

		    	            break;
		    	            
		           case 2:
		        	   
		        	       System.out.println("Trip\t\tExecutive\tRestaurant\tDestination\tOrders\t\tPickUp\t\t\tDelivery\tDelivery Charge");
		    	            
		        	       Map<Integer,Booking> allBookings=callDrive.getAllBookings();
		        	       
		        	       for( Integer bookingId : allBookings.keySet() )
		        	       {
		        	    	   System.out.println( allBookings.get(bookingId) );
		        	       }
		        	       
		        	       
		        	       break;
		        	       
		           case 3:
		        	   
		        	      System.out.println("Executive\tAllowances\tDeliveryCharge\tTotal");
		        	       
		        	      Map< String , DeliveryExecutive > allDeliveryExecutives=callDrive.getAllDeliveryExecutives();
		        	      
		        	      for( String executive : allDeliveryExecutives.keySet()  )
                          {
                        	    System.out.println( allDeliveryExecutives.get( executive ) );
                          } 
		        	      
		        	      break;
		        	      
		        	default:
		        		
		        		  condition=false;
		        		  
		        		  break;
		        	      
		      }
		  }
		   
	   }
	   
	   
	   
	   
	   
	   static String chooseLocation( Scanner input  )
	   {
		   
		 String location="";
		 boolean condition=true;  
		   
		 while( condition ) 
		 {
		       System.out.println( "Press 1-->A\n"
		   		             + "Press 2-->B\n"
		   		             + "Press 3-->C\n"
		   		             + "Press 4-->D\n"
		   		             + "Press 5-->E\n");
		       
		       int option=0;
		       
		       try
		       {
		          option=input.nextInt();
		          input.nextLine();
		       }
		       catch( InputMismatchException ex )
		       {
		    	    System.out.println("Enter Number Only");
		    	    input.nextLine();
		       }
		       
		       
		       
		       switch( option  )
		       {
		       
		             case 1:
                             
		            	 location="A";
		            	 condition=false;
		            	 break;
		            	 
		             case 2:
		            	 
		            	 location="B";
		            	 condition=false;
		            	 break;
		            	 
		             case 3:
		            	 
		            	 location="C";
		            	 condition=false;
		            	 break;
		            	 
		             case 4:
		            	 
		            	 location="D";
		            	 condition=false;
		            	 break;
		            	 
		             case 5:
		            	 
		            	 location="E";
		            	 condition=false;
		            	 break;
		            	 
		            default:
		            	
		            	 System.out.println("Enter the exist value");
		            	 break;
		       
		       }
		 }     
		       return location;
		       
	   }
	   
	   
	   
	   static String getMeredian( Scanner input  )
	   {
		    String meredian="";
		   
		    boolean condition=true;
		    
		    while( condition )
		    
		    {
		          System.out.println("Choose 1-->AM\nChoose 2-->PM");
		  
		          int option=0;
		       
		           try
		           {
		               option=input.nextInt();
		               input.nextLine();
		           }
		           catch( InputMismatchException ex )
		           {
		    	        System.out.println("Enter Number Only");
		    	        input.nextLine();
		           }
		           
		       switch(  option )
		       {
		             case 1:
		            	 
		            	 meredian="AM";
		            	 condition=false;
		            	 break;
		            	 
		             case 2:
		            	 
		            	 meredian="PM";
		            	 condition=false;
		            	 break;
		            	 
		             default:
		            	 
		            	 System.out.println("Enter the exist value");
		            	 break;
		   
		       }
		       
		    }
		    
		          return meredian;
		           
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
